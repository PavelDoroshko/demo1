package com.example.demo.service;

import com.example.demo.model.Cat;
import com.example.demo.model.Person;
import lombok.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class ExcelService {

    private final PersonServiceImpl personService;

    public ExcelService(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @Transactional
    Person getPerson(Long id) {
        Person person = personService.readOne(id);
        return person;
    }

    String getCat(Long person_id) {
        List<Cat> cats = new ArrayList<>();
        cats = getPerson(person_id).getCats();
       /* List<String> nameCats = cats.stream()
                .map(cat -> cat.getName())
                .collect(Collectors.toList());
*/
        StringBuilder out = new StringBuilder();
        for (Cat cat : cats) {
            out.append(cat.getName());
            out.append("  ");
        }
        return out.toString();

      /*  List<String> nam = new ArrayList<>();
for(Cat cat:cats){
  nam.add(cat.getName());
}
        String name = nam.toString();
        return name;*/
    }

    @SneakyThrows
    public void buildExcelDocument(Long id) {


        String name = getPerson(id).getName();
        Integer age = getPerson(id).getAge();
        String ageString = age.toString();
        String surname = getPerson(id).getSurName();
        String catname = getPerson(id).getCats().toString();
        //String catname = getCat(id);

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet(" Student Data ");
        XSSFRow row;
        int n = 1;


        Map<Integer, Object[]> studentData = new TreeMap<Integer, Object[]>();
        studentData.put(n, new Object[]{"AGE", "NAME", "SURNAME"});
        studentData.put(++n, new Object[]{ageString, name, surname});
        studentData.put(++n, new Object[]{ageString, name, surname});
        Set<Integer> keyid = studentData.keySet();

        int rowid = 0;

        for (Integer key : keyid) {

            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = studentData.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue(String.valueOf(obj));
            }
        }
        FileOutputStream out = new FileOutputStream(
                new File("/home/pavel/first.xlsx"));
//new File ("d:/first.xlsx"));
        workbook.write(out);
        out.close();


    }

    @SneakyThrows
    public XSSFWorkbook buildExcel() {

        List<Person> persons = personService.readAll();

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet(" Student Data ");
        XSSFRow row;

        int rowid = 0;
        Iterator<Person> iter = persons.iterator();
        while (iter.hasNext()) {

            int cellid = 0;

               if (rowid == 0) {
                    row = spreadsheet.createRow(rowid);
                    String[] column = new String[]{"AGE", "NAME", "SURNAME", "CAT"};
                    int hedarCellid = 0;
                    for (String str : column) {
                    Cell cell = row.createCell(hedarCellid++);
                    cell.setCellValue(str);
                }
            }
            Person person = iter.next();
            List<Cat> cats = person.getCats();
            StringBuilder stringBuilder = new StringBuilder();
            for (Cat cat : cats) {
                stringBuilder.append(cat.getName())
                        .append(",");
            }
            if (!person.getCats().isEmpty()) stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));

            String[] pers = new String[]{person.getAge().toString(), person.getName(), person.getSurName(), stringBuilder.toString()};

            row = spreadsheet.createRow(++rowid);

            for (String str : pers) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue(str);
            }
        }
        for (int columnIndex = 0; columnIndex < 4; columnIndex++) {
            spreadsheet.autoSizeColumn(columnIndex);
        }
        return workbook;

    }

    public ByteArrayResource export() throws IOException {

        XSSFWorkbook workbook = buildExcel();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        workbook.write(baos);
        byte[] xls = baos.toByteArray();
        ByteArrayResource byteArrayResource = new ByteArrayResource(xls) {

            @Override
            public String getFilename() {
                return "excel";
            }
        };
        return byteArrayResource;
    }
}