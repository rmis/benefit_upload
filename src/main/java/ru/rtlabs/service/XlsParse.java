package ru.rtlabs.service;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.rtlabs.Entity.Benefit;
import ru.rtlabs.Entity.Entity;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class XlsParse {

    private Service service;
    private boolean has;
    private static int patientCount;
    private static int patientAddedCount;
    private static int patientBenefitHas;
    private static int patientBenefitAdded;

    public void parse(String file, String file2) {
        System.out.println("parsing...");
        try {
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
            XSSFSheet sheet = wb.getSheetAt(0);

             for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
           // for (int i = 10000; i < sheet.getLastRowNum(); i++) {
                XSSFRow row = sheet.getRow(i);
                Entity entity = new Entity();
                for (int j = 0; j < row.getLastCellNum(); j++) {

                    XSSFCell cell = row.getCell(j);
                    switch (j) {
                        case 0:
                            if (cell == null) {
                                continue;
                            } else {
                                switch (cell.getCellType()) {
                                    case XSSFCell.CELL_TYPE_STRING:
                                        entity.setSnils(cell.getStringCellValue());
                                        break;
                                    case XSSFCell.CELL_TYPE_NUMERIC:
                                        entity.setSnils(String.valueOf(cell.getNumericCellValue()));
                                        break;
                                }
                            }
                            break;
                        case 1:
                            if (cell == null) {
                                continue;
                            } else {
                                switch (cell.getCellType()) {
                                    case XSSFCell.CELL_TYPE_STRING:
                                        entity.setNpp(cell.getStringCellValue());
                                        break;
                                    case XSSFCell.CELL_TYPE_NUMERIC:
                                        entity.setNpp(String.valueOf(cell.getNumericCellValue()));
                                        break;
                                }
                            }
                            break;
                        case 4:
                            if (cell == null) {
                                continue;
                            } else {
                                switch (cell.getCellType()) {
                                    case XSSFCell.CELL_TYPE_STRING:
                                        entity.setSurname(cell.getStringCellValue());
                                        break;
                                    case XSSFCell.CELL_TYPE_NUMERIC:
                                        entity.setSurname(String.valueOf(cell.getNumericCellValue()));
                                        break;
                                }
                            }
                            break;
                        case 5:
                            if (cell == null) {
                                continue;
                            } else {
                                switch (cell.getCellType()) {
                                    case XSSFCell.CELL_TYPE_STRING:
                                        entity.setName(cell.getStringCellValue());
                                        break;
                                    case XSSFCell.CELL_TYPE_NUMERIC:
                                        entity.setName(String.valueOf(cell.getNumericCellValue()));
                                        break;
                                }
                            }

                        case 6:
                            if (cell == null) {
                                continue;
                            } else {
                                switch (cell.getCellType()) {
                                    case XSSFCell.CELL_TYPE_STRING:
                                        entity.setPatrName(cell.getStringCellValue());
                                        break;
                                    case XSSFCell.CELL_TYPE_NUMERIC:
                                        entity.setPatrName(String.valueOf(cell.getNumericCellValue()));
                                        break;
                                }
                            }
                            break;
                        case 7:
                            if (cell == null) {
                                continue;
                            } else {
                                switch (cell.getCellType()) {
                                    case XSSFCell.CELL_TYPE_STRING:
                                        entity.setGender(cell.getStringCellValue());
                                        break;
                                    case XSSFCell.CELL_TYPE_NUMERIC:
                                        entity.setGender(String.valueOf(cell.getNumericCellValue()));
                                        break;
                                }
                            }
                            break;
                        case 10:
                            if (cell == null) {
                                continue;
                            } else {
                                switch (cell.getCellType()) {
                                    case XSSFCell.CELL_TYPE_STRING:
                                        entity.setDocType(cell.getStringCellValue());
                                        break;
                                    case XSSFCell.CELL_TYPE_NUMERIC:
                                        entity.setDocType(String.valueOf(cell.getNumericCellValue()));
                                        break;
                                }
                            }
                            break;
                        case 14:
                            if (cell == null) {
                                continue;
                            } else {
                                switch (cell.getCellType()) {
                                    case XSSFCell.CELL_TYPE_STRING:
                                        entity.setDocSeries(cell.getStringCellValue());
                                        break;
                                    case XSSFCell.CELL_TYPE_NUMERIC:
                                        entity.setDocSeries(String.valueOf(cell.getNumericCellValue()));
                                        break;
                                }
                            }
                            break;
                        case 15:
                            if (cell == null) {
                                continue;
                            } else {
                                switch (cell.getCellType()) {
                                    case XSSFCell.CELL_TYPE_STRING:
                                        entity.setNumber(cell.getStringCellValue());
                                        break;
                                    case XSSFCell.CELL_TYPE_NUMERIC:
                                        entity.setNumber(String.valueOf(cell.getNumericCellValue()));
                                        break;
                                }
                            }
                            break;
                        case 31:
                            if (cell == null) {
                                continue;
                            } else {
                                switch (cell.getCellType()) {
                                    case XSSFCell.CELL_TYPE_STRING:
                                        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                                        Date parsedB = format.parse(cell.getStringCellValue());
                                        java.sql.Date sqlD = new java.sql.Date(parsedB.getTime());
                                        entity.setBdate(sqlD);
                                        break;
                                    case XSSFCell.CELL_TYPE_NUMERIC:
                                        DateFormat formatqq = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy", Locale.ENGLISH);
                                        Date parseB = formatqq.parse(String.valueOf(cell.getDateCellValue()));
                                        java.sql.Date sqlD2 = new java.sql.Date(parseB.getTime());
                                        entity.setBdate(sqlD2);
                                        break;
                                }
                            }
                            break;
                        case 32:
                            if (cell == null) {
                                continue;
                            } else {
                                switch (cell.getCellType()) {
                                    case XSSFCell.CELL_TYPE_STRING:
                                        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                                        Date parsedB = format.parse(cell.getStringCellValue());
                                        java.sql.Date sqlD = new java.sql.Date(parsedB.getTime());
                                        entity.setIssuerDate(sqlD);
                                        break;
                                    case XSSFCell.CELL_TYPE_NUMERIC:
                                        DateFormat formatqq = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy", Locale.ENGLISH);
                                        Date parseB = formatqq.parse(String.valueOf(cell.getDateCellValue()));
                                        java.sql.Date sqlD2 = new java.sql.Date(parseB.getTime());
                                        entity.setIssuerDate(sqlD2);
                                        break;
                                }
                            }
                            break;
                        case 33:
                            if (cell == null) {
                                continue;
                            } else {
                                switch (cell.getCellType()) {
                                    case XSSFCell.CELL_TYPE_STRING:
                                        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                                        Date parsedB = format.parse(cell.getStringCellValue());
                                        java.sql.Date sqlD = new java.sql.Date(parsedB.getTime());
                                        entity.setBenefitFederalStartDate(sqlD);
                                        break;
                                    case XSSFCell.CELL_TYPE_NUMERIC:
                                        DateFormat formatqq = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy", Locale.ENGLISH);
                                        Date parseB = formatqq.parse(String.valueOf(cell.getDateCellValue()));
                                        java.sql.Date sqlD2 = new java.sql.Date(parseB.getTime());
                                        entity.setBenefitFederalStartDate(sqlD2);
                                        break;
                                }
                            }
                            break;
                        case 34:
                            if (cell == null) {
                                continue;
                            } else {
                                switch (cell.getCellType()) {
                                    case XSSFCell.CELL_TYPE_STRING:
                                        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                                        Date parsedB = format.parse(cell.getStringCellValue());
                                        java.sql.Date sqlD = new java.sql.Date(parsedB.getTime());
                                        entity.setBenefitFederalEndDate(sqlD);
                                        break;
                                    case XSSFCell.CELL_TYPE_NUMERIC:
                                        DateFormat formatqq = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy", Locale.ENGLISH);
                                        Date parseB = formatqq.parse(String.valueOf(cell.getDateCellValue()));
                                        java.sql.Date sqlD2 = new java.sql.Date(parseB.getTime());
                                        entity.setBenefitFederalEndDate(sqlD2);
                                        break;
                                }
                            }
                            break;
                        case 35:
                            if (cell == null) {
                                continue;
                            } else {
                                switch (cell.getCellType()) {
                                    case XSSFCell.CELL_TYPE_STRING:
                                        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                                        Date parsedB = format.parse(cell.getStringCellValue());
                                        java.sql.Date sqlD = new java.sql.Date(parsedB.getTime());
                                        entity.setBenefitOblStartDate(sqlD);
                                        break;
                                    case XSSFCell.CELL_TYPE_NUMERIC:
                                        DateFormat formatqq = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy", Locale.ENGLISH);
                                        Date parseB = formatqq.parse(String.valueOf(cell.getDateCellValue()));
                                        java.sql.Date sqlD2 = new java.sql.Date(parseB.getTime());
                                        entity.setBenefitOblStartDate(sqlD2);
                                        break;
                                }
                            }
                            break;
                        case 36:
                            if (cell == null) {
                                continue;
                            } else {
                                switch (cell.getCellType()) {
                                    case XSSFCell.CELL_TYPE_STRING:
                                        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                                        Date parsedB = format.parse(cell.getStringCellValue());
                                        java.sql.Date sqlD = new java.sql.Date(parsedB.getTime());
                                        entity.setBenefitOblEndDate(sqlD);
                                        break;
                                    case XSSFCell.CELL_TYPE_NUMERIC:
                                        DateFormat formatqq = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy", Locale.ENGLISH);
                                        Date parseB = formatqq.parse(String.valueOf(cell.getDateCellValue()));
                                        java.sql.Date sqlD2 = new java.sql.Date(parseB.getTime());
                                        entity.setBenefitOblEndDate(sqlD2);
                                        break;
                                }
                            }
                            break;
                        case 37:
                            if (cell == null) {
                                continue;
                            } else {
                                switch (cell.getCellType()) {
                                    case XSSFCell.CELL_TYPE_STRING:
                                        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                                        Date parsedB = format.parse(cell.getStringCellValue());
                                        java.sql.Date sqlD = new java.sql.Date(parsedB.getTime());
                                        entity.setBenefitDenialDate(sqlD);
                                        break;
                                    case XSSFCell.CELL_TYPE_NUMERIC:
                                        DateFormat formatqq = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy", Locale.ENGLISH);
                                        Date parseB = formatqq.parse(String.valueOf(cell.getDateCellValue()));
                                        java.sql.Date sqlD2 = new java.sql.Date(parseB.getTime());
                                        entity.setBenefitDenialDate(sqlD2);
                                        break;
                                }
                            }
                            break;
                    }
                }
                if (entity.getSnils() != null){
                    entity.setId(service.search(entity));
                }else {
                    entity.setId(service.searchSnils(entity));
                }

            ++patientCount;
                if (entity.getId() != 0) {
                   // service.benefitAdd(entity);
                    System.out.println(entity.toString());
                    service.nppAdd(entity);
                    /*if (!service.hasPassp(entity)){
                        service.passpInsert(entity);
                    }*/
                    if (!service.hasSnils(entity) && entity.getSnils() != null){
                        entity.setSnilsCodeId(service.getCodeId());
                        service.snilsInsert(entity);
                    }
                    FileWriter fileWriterq = new FileWriter("nppAdded.txt", true);
                    BufferedWriter bufq = new BufferedWriter(fileWriterq);
                    bufq.write("Пациент " + entity.toString());
                    bufq.newLine();
                    bufq.write("--------------");
                    bufq.newLine();
                    bufq.flush();
                    bufq.close();
                }else {
                    entity.setId(service.getNewId());
                    System.out.println(entity.toString());
                    service.patientInsert(entity);
                    service.nppAdd(entity);
                    entity.setSnilsCodeId(service.getCodeId());
                    service.codeInsert(entity);
                    service.documentsInsert(entity);
                    FileWriter fileWriterq = new FileWriter("new_patient.txt", true);
                    BufferedWriter bufq = new BufferedWriter(fileWriterq);
                    bufq.write("Пациент осутствует в Базе Данных. don't worry about it. мы его добавили " + entity.toString());
                    bufq.newLine();
                    bufq.write("--------------");
                    bufq.newLine();
                    bufq.flush();
                    bufq.close();
                    ++patientAddedCount;
                }
            }
            secondFileParse(file2);
        } catch (ParseException | IOException e1) {
            e1.printStackTrace();
        }
    }

    private void secondFileParse(String file) {
        System.out.println("secondFileParse");

        try {
            XSSFWorkbook wb2 = new XSSFWorkbook(new FileInputStream(file));
            XSSFSheet sheet2 = wb2.getSheetAt(0);

            for (int x = 1; x < sheet2.getLastRowNum() + 1; x++) {
                XSSFRow row2 = sheet2.getRow(x);
                Benefit benefit = new Benefit();
                for (int y = 0; y < row2.getLastCellNum(); y++) {
                    XSSFCell cell2 = row2.getCell(y);
                    //XSSFCell cell = row2.getCell(0);
                        switch (y) {

                            case 1:
                                if (cell2 == null) {
                                    continue;
                                } else {
                                    switch (cell2.getCellType()) {
                                        case XSSFCell.CELL_TYPE_STRING:
                                            benefit.setNpp(cell2.getStringCellValue());
                                            break;
                                        case XSSFCell.CELL_TYPE_NUMERIC:
                                            benefit.setNpp(String.valueOf(cell2.getNumericCellValue()));
                                            break;
                                    }
                                }
                                break;
                            case 3:
                                if (cell2 == null) {
                                            continue;
                                        } else {
                                            switch (cell2.getCellType()) {
                                                case XSSFCell.CELL_TYPE_STRING:
                                                    benefit.setBenefitCode(cell2.getStringCellValue());

                                                    break;
                                                case XSSFCell.CELL_TYPE_NUMERIC:
                                                    benefit.setBenefitCode(String.valueOf(cell2.getNumericCellValue()));

                                                    break;
                                            }
                                        }
                                        break;
                                    case 4:
                                        if (cell2 == null) {
                                            continue;
                                        } else {
                                            switch (cell2.getCellType()) {
                                                case XSSFCell.CELL_TYPE_STRING:
                                                    benefit.setBenefitName(cell2.getStringCellValue());
                                                    break;
                                                case XSSFCell.CELL_TYPE_NUMERIC:
                                                    benefit.setBenefitName(String.valueOf(cell2.getNumericCellValue()));
                                                    break;
                                            }
                                        }
                                        break;
                                    case 5:
                                        if (cell2 == null) {
                                            continue;
                                        } else {
                                            switch (cell2.getCellType()) {
                                                case XSSFCell.CELL_TYPE_STRING:
                                                    benefit.setBenefitSer(cell2.getStringCellValue());
                                                    break;
                                                case XSSFCell.CELL_TYPE_NUMERIC:
                                                    benefit.setBenefitSer(String.valueOf(cell2.getNumericCellValue()));
                                                    break;
                                            }
                                        }
                                        break;
                                    case 6:
                                        if (cell2 == null) {
                                            continue;
                                        } else {
                                            switch (cell2.getCellType()) {
                                                case XSSFCell.CELL_TYPE_STRING:
                                                    benefit.setBenefitNumber(cell2.getStringCellValue());
                                                    break;
                                                case XSSFCell.CELL_TYPE_NUMERIC:
                                                    benefit.setBenefitNumber(String.valueOf(cell2.getNumericCellValue()));
                                                    break;
                                            }
                                        }
                                        break;
                                    case 7:
                                        if (cell2 == null) {
                                            continue;
                                        } else {
                                            switch (cell2.getCellType()) {
                                                case XSSFCell.CELL_TYPE_STRING:
                                                    benefit.setBenefitIssuer(cell2.getStringCellValue());
                                                    break;
                                                case XSSFCell.CELL_TYPE_NUMERIC:
                                                    benefit.setBenefitIssuer(String.valueOf(cell2.getNumericCellValue()));
                                                    break;
                                            }
                                        }
                                        break;
                                    case 9:
                                        if (cell2 == null) {
                                            continue;
                                        } else {
                                            switch (cell2.getCellType()) {
                                                case XSSFCell.CELL_TYPE_STRING:
                                                    DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                                                    Date parsedB = format.parse(cell2.getStringCellValue());
                                                    java.sql.Date sqlD = new java.sql.Date(parsedB.getTime());
                                                    benefit.setBenefitGiven(sqlD);
                                                    break;
                                                case XSSFCell.CELL_TYPE_NUMERIC:
                                                    DateFormat formatqq = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy", Locale.ENGLISH);
                                                    Date parseB = formatqq.parse(String.valueOf(cell2.getDateCellValue()));
                                                    java.sql.Date sqlD2 = new java.sql.Date(parseB.getTime());
                                                    benefit.setBenefitGiven(sqlD2);
                                                    break;
                                            }
                                        }
                                        break;
                                    case 10:
                                        if (cell2 == null) {
                                            continue;
                                        } else {
                                            switch (cell2.getCellType()) {
                                                case XSSFCell.CELL_TYPE_STRING:
                                                    DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                                                    Date parsedB = format.parse(cell2.getStringCellValue());
                                                    java.sql.Date sqlD = new java.sql.Date(parsedB.getTime());
                                                    benefit.setBenefitStarDate(sqlD);
                                                    break;
                                                case XSSFCell.CELL_TYPE_NUMERIC:
                                                    DateFormat formatqq = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy", Locale.ENGLISH);
                                                    Date parseB = formatqq.parse(String.valueOf(cell2.getDateCellValue()));
                                                    java.sql.Date sqlD2 = new java.sql.Date(parseB.getTime());
                                                    benefit.setBenefitStarDate(sqlD2);
                                                    break;
                                            }
                                        }
                                        break;
                                    case 11:
                                        if (cell2 == null) {
                                            continue;
                                        } else {
                                            switch (cell2.getCellType()) {
                                                case XSSFCell.CELL_TYPE_STRING:
                                                    DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                                                    Date parsedB = format.parse(cell2.getStringCellValue());
                                                    java.sql.Date sqlD = new java.sql.Date(parsedB.getTime());
                                                    benefit.setBenefitEndDate(sqlD);
                                                    break;
                                                case XSSFCell.CELL_TYPE_NUMERIC:
                                                    DateFormat formatqq = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy", Locale.ENGLISH);
                                                    Date parseB = formatqq.parse(String.valueOf(cell2.getDateCellValue()));
                                                    java.sql.Date sqlD2 = new java.sql.Date(parseB.getTime());
                                                    benefit.setBenefitEndDate(sqlD2);
                                                    break;
                                            }
                                        }
                                        break;
                                }
                            }
                 System.out.println(benefit.toString());
                 benefit.setId(service.search2(benefit));
               /* if (!service.searchCodes().contains(benefit.getBenefitCode())){
                    FileWriter fileWriterq = new FileWriter("codes.txt", true);
                    BufferedWriter bufq = new BufferedWriter(fileWriterq);
                    bufq.write("Код отсутствует в РМИС " + benefit.toString());
                    bufq.newLine();
                    bufq.write("--------------");
                    bufq.newLine();
                    bufq.flush();
                    bufq.close();
                }*/
               if (benefit.getId() != 0 ){
                    if (!service.hasBenefit(benefit) && benefit.getBenefitName() != null){
                        service.benefitAdd(benefit);
                        FileWriter fileWriterq = new FileWriter("added.txt", true);
                        BufferedWriter bufq = new BufferedWriter(fileWriterq);
                        bufq.write("Пациенту добавлены льготы " + benefit.toString());
                        bufq.newLine();
                        bufq.write("--------------");
                        bufq.newLine();
                        bufq.flush();
                        bufq.close();
                        ++patientBenefitAdded;
                    }else{
                        FileWriter fileWriterq = new FileWriter("hasBenefit.txt", true);
                        BufferedWriter bufq = new BufferedWriter(fileWriterq);
                        bufq.write("Пациенту не добавлены, так как они у него присутствуют " + benefit.toString());
                        bufq.newLine();
                        bufq.write("--------------");
                        bufq.newLine();
                        bufq.flush();
                        bufq.close();
                        ++patientBenefitHas;
                    }
                }else {
                    FileWriter fileWriterq = new FileWriter("notAdded.txt", true);
                    BufferedWriter bufq = new BufferedWriter(fileWriterq);
                    bufq.write("Пациенту не добавлены npp из прошлого файла " + benefit.toString());
                    bufq.newLine();
                    bufq.write("--------------");
                    bufq.newLine();
                    bufq.flush();
                    bufq.close();
                }
                    }

            FileWriter fileWriterq = new FileWriter("stats.txt", true);
            BufferedWriter bufq = new BufferedWriter(fileWriterq);
            bufq.write("Кол-во пациентов в файле: " + patientCount);
            bufq.newLine();
            bufq.write("Кол-во добавленных пациентов в РМИС: " + patientAddedCount);
            bufq.newLine();
            bufq.write("Кол-во пациентов, у которых уже имеется льгота: " + patientBenefitHas);
            bufq.newLine();
            bufq.write("Кол-во добавленных льгот: " + patientBenefitAdded);
            bufq.newLine();
            bufq.flush();
            bufq.close();
                } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
    public void setService(Service service) {
        this.service = service;
    }
    }






