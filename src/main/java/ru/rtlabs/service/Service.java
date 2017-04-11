package ru.rtlabs.service;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.rtlabs.Entity.Benefit;
import ru.rtlabs.Entity.Entity;
import ru.rtlabs.Entity.Indiv;
import ru.rtlabs.rowmapper.DocumentRowMapper;
import ru.rtlabs.rowmapper.IndivRowMapper;
import ru.rtlabs.rowmapper.PatientRowMapper;
import java.util.List;
import java.util.Random;

public class Service {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer search(Entity entity){
        List<Indiv> indiv = null;
        StringBuilder number = new StringBuilder();
        if (entity.getSnils() != null){
            char[] a = entity.getSnils().toCharArray();
            for (char c : a) {
                if (c != '-'){
                    if (c != ' '){
                        number.append(c);
                    }
                }
            }
        }
        String sql = "SELECT * from pim_individual_doc where number like ?";
        indiv = jdbcTemplate.query(sql, new Object[] {number.toString()}, new DocumentRowMapper());
        if (indiv.size() == 0 && entity.getSnils() != null){
            indiv = jdbcTemplate.query(sql, new Object[] {entity.getSnils()}, new DocumentRowMapper());
        }
        return (indiv.size() != 0 ? indiv.get(0).getId() : searchSnils(entity));
    }
    public Integer searchSnils(Entity entity){

        List<Indiv> indiv = null;
        String sql = "select * from pim_individual where replace(upper(name), 'ё', 'е') = replace(upper(?), 'ё', 'е') " +
                "and replace(upper(surname), 'ё', 'е') = replace(upper(?), 'ё', 'е') " +
                "and replace(upper(patr_name), 'ё', 'е') = replace(upper(?), 'ё', 'е') and birth_dt = ?";
        indiv = jdbcTemplate.query(sql, new Object[] {entity.getName(), entity.getSurname(), entity.getPatrName(), entity.getBdate()}, new IndivRowMapper());
        return (indiv.size() != 0 ? indiv.get(0).getId() : 0);
    }
    public Integer search2(Benefit benefit){
        String npp2 = "npp" + benefit.getNpp();
        List<Indiv> indiv = null;
        String sql = "select * from pci_patient where note = ?";
        indiv = jdbcTemplate.query(sql, new Object[] {npp2}, new PatientRowMapper());
        return (indiv.size() != 0 ? indiv.get(0).getId() : 0);
    }
    public Boolean hasBenefit(Benefit benefit) {
        int benefitDef = 0;
        int benefitType = 0;
        switch (benefit.getBenefitCode()) {
            case "020":
                benefitDef = 5;
                benefitType = 2;
                break;
            case "010":
                benefitDef = 4;
                benefitType = 2;
                break;
            case "083":
                benefitDef = 1;
                benefitType = 2;
                break;
            case "082":
                benefitDef = 2;
                benefitType = 2;
                break;
            case "081":
                benefitDef = 3;
                benefitType = 2;
                break;
            case "060":
                benefitDef = 10;
                benefitType = 2;
                break;
            case "10":
                benefitDef = 13;
                benefitType = 2;
                break;
            case "4":
                benefitDef = 17;
                benefitType = 2;
                break;
            case "890":
                benefitDef = 28;
                benefitType = 7;
                break;
            case "5":
                benefitDef = 18;
                benefitType = 2;
                break;
            case "012":
                benefitDef = 61;
                benefitType = 2;
                break;
            case "050":
                benefitDef = 8;
                benefitType = 2;
                break;
            case "062":
                benefitDef = 62;
                benefitType = 2;
                break;
            case "094":
                benefitDef = 67;
                benefitType = 2;
                break;
            case "030":
                benefitDef = 6;
                benefitType = 2;
                break;
            case "084":
                benefitDef = 12;
                benefitType = 2;
                break;
            case "123":
                benefitDef = 66;
                benefitType = 2;
                break;
            case "124":
                benefitDef = 66;
                benefitType = 2;
                break;
            case "120":
                benefitDef = 9;
                benefitType = 2;
                break;
            case "040":
                benefitDef = 7;
                benefitType = 2;
                break;
            case "092":
                benefitDef = 18;
                benefitType = 2;
                break;
            case "093":
                benefitDef = 64;
                benefitType = 2;
                break;
            case "098":
                benefitDef = 55;
                benefitType = 2;
                break;
            case "111":
                benefitDef = 65;
                benefitType = 2;
                break;
            case "112":
                benefitDef = 17;
                benefitType = 2;
                break;
            case "113":
                benefitDef = 13;
                benefitType = 2;
                break;
            case "000":
                benefitDef = 27;
                benefitType = 5;
                break;
            case "501":
                benefitDef = 32;
                benefitType = 9;
                break;
            case "502":
                benefitDef = 33;
                benefitType = 9;
                break;
            case "503":
                benefitDef = 34;
                benefitType = 9;
                break;
            case "140":
                benefitDef = 56;
                benefitType = 2;
                break;
            case "011":
                benefitDef = 54;
                benefitType = 2;
                break;
            case "131":
                benefitDef = 58;
                benefitType = 2;
                break;

            case "715":
                benefitDef = 29;
                benefitType = 9;
                break;

            case "510":
                benefitDef = 52;
                benefitType = 9;
                break;

            case "531":
                benefitDef = 53;
                benefitType = 9;
                break;


            case "064":
                benefitDef = 57;
                benefitType = 2;
                break;

            case "150":
                benefitDef = 59;
                benefitType = 2;
                break;

            case "132":
                benefitDef = 60;
                benefitType = 2;
                break;
            case "091":
                benefitDef = 63;
                benefitType = 2;
                break;

        }
        try {
            String query = "select 1 from pci_benefit where benefit_def_id = ? and benefit_type_id = ? and doc_number = ? and patient_id = ? and doc_issuer_dt = ? limit 1";
            String number = benefit.getBenefitSer() + benefit.getBenefitNumber();
            jdbcTemplate.queryForObject(query, new Object[]{benefitDef, benefitType, number, benefit.getId(), benefit.getBenefitGiven()}, Long.class);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
}
    public Integer getNewId(){
        return jdbcTemplate.queryForObject(
                "SELECT nextval('pim_party_id_seq')", new Object[] {}, Integer.class);
    }
    public void patientInsert(Entity entity){

        int gender = 1;
        if (entity.getGender() != null){
            if (entity.getGender().toLowerCase().contains("ж")){
                gender = 2;
            }
        }
        String party = "INSERT INTO pim_party(id, note, type_id) VALUES (?, 'загрузка списка льгот', 1)";
        String indiv = "INSERT INTO pim_individual(id, birth_dt, name, patr_name, surname, gender_id) VALUES (?, ?, ?, ?, ?, ?)";
        String patient = "INSERT INTO pci_patient (id, note) VALUES (?, ?)";
        jdbcTemplate.update(party, new Object[] {entity.getId()});
        jdbcTemplate.update(indiv, new Object[] {entity.getId(), entity.getBdate(), entity.getName(), entity.getPatrName(), entity.getSurname(), gender});
        jdbcTemplate.update(patient, new Object[] {entity.getId(), "загрузка из файла льготников"});
    }
    public Integer getCodeId(){
        return jdbcTemplate.queryForObject(
                "SELECT nextval('pim_indiv_code_id_seq')", new Object[] {}, Integer.class);
    }
    public void documentsInsert(Entity entity) {

        String snils = "INSERT INTO pim_individual_doc (id, type_id, number, code_id, indiv_id, is_active, note) VALUES (nextval('pim_individual_doc_id_seq'), 19, ?, ?, ?, TRUE, 'Загрузчик льгот')";
       // String pass = "INSERT INTO pim_individual_doc (id, type_id, series, number, indiv_id, is_active, note) VALUES (nextval('pim_individual_doc_id_seq'), 13, ?, ?, ?, TRUE, 'Загрузчик льгот')";
        if (entity.getSnils() != null){
            jdbcTemplate.update(snils, new Object[]{entity.getSnils(), entity.getSnilsCodeId(), entity.getId()});
        }

        /*try {
            jdbcTemplate.update(pass, new Object[]{entity.getDocSeries(), entity.getNumber().substring(2), entity.getId()});
        } catch (Exception e) {
            FileWriter fileWriterq = null;
            try {
                fileWriterq = new FileWriter("error.txt", true);
                BufferedWriter bufq = new BufferedWriter(fileWriterq);
                bufq.write("Пациенту не проставлен паспорт. Т.к. присутствует у другого пациента " + entity);
                bufq.newLine();
                bufq.write("--------------");
                bufq.newLine();
                bufq.flush();
                bufq.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }*/
        }
    public void codeInsert(Entity entity){
        String insert = "INSERT INTO pim_indiv_code(id, code, issue_dt, type_id, indiv_id) VALUES (nextval('pim_indiv_code_id_seq'), ?, current_date, 7, ?)";
        String snils = "INSERT INTO pim_indiv_code(id, code, issue_dt, type_id, indiv_id) VALUES (?, ?, current_date, 1, ?)";
        char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 16; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String code = sb.toString().toUpperCase();
        jdbcTemplate.update(insert, new Object[] {code, entity.getId()});
       if (entity.getSnils() != null){
           jdbcTemplate.update(snils, new Object[] {entity.getSnilsCodeId(), entity.getSnils(), entity.getId()});
       }

    }
    public Boolean hasPassp(Entity entity){
        try {
            String query = "select 1 from pim_individual_doc where indiv_id = ? and type_id = 13 limit 1";

            jdbcTemplate.queryForObject(query, new Object[]{entity.getId()}, Long.class);
            return true;
        }catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
    public Boolean hasSnils(Entity entity){
        try {
            String query = "select 1 from pim_individual_doc where indiv_id = ? and type_id = 19 limit 1";

            jdbcTemplate.queryForObject(query, new Object[]{entity.getId()}, Long.class);
            return true;
        }catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
    public void passpInsert(Entity entity){
        String pass = "INSERT INTO pim_individual_doc (id, type_id, series, number, indiv_id, is_active, note) VALUES (nextval('pim_individual_doc_id_seq'), 13, ?, ?, ?, TRUE, 'Загрузчик льгот')";
        jdbcTemplate.update(pass, new Object[] {entity.getDocSeries(), entity.getNumber().substring(2), entity.getId()});
    }
    public void snilsInsert(Entity entity){
        String snils = "INSERT INTO pim_individual_doc (id, type_id, number, code_id, indiv_id, is_active, note) VALUES (nextval('pim_individual_doc_id_seq'), 19, ?, ?, ?, TRUE, 'Загрузчик льгот')";
        String snilsCode = "INSERT INTO pim_indiv_code(id, code, issue_dt, type_id, indiv_id) VALUES (?, ?, current_date, 1, ?)";
        try {
            jdbcTemplate.update(snilsCode, new Object[] {entity.getSnilsCodeId(), entity.getSnils(), entity.getId()});
            jdbcTemplate.update(snils, new Object[] {entity.getSnils(), entity.getSnilsCodeId(), entity.getId()});
        }catch (Exception e){
                e.printStackTrace();

        }
    }
   /* public Integer search2(String npp){
        String npp2 = "npp" + npp;
        System.out.println("Поиск по NPP " + npp2);
        String sql = "select id from pci_patient where note = ?";
       // List<Indiv> indiv = null;

        return jdbcTemplate.queryForInt(sql, npp2);
        //indiv = jdbcTemplate.query(sql, npp, new IndivRowMapper());
        //return (indiv.size() != 0 ? indiv.get(0).getId() : 0);
    }*/

    public void benefitAdd(Benefit benefit){
        String sql = "INSERT INTO pci_benefit(id, created_dt, benefit_def_id, benefit_type_id, patient_id, doc_issuer, doc_issuer_dt, doc_name, doc_number, from_dt, to_dt) VALUES (nextval('pci_benefit_id_seq'), current_date, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int benefitDef = 0;
        int benefitType = 0;
        StringBuilder number = new StringBuilder();
        if (benefit.getBenefitSer() != null){
            number.append(benefit.getBenefitSer());
        }else {
            number.append("");
        }
        if (benefit.getBenefitNumber() != null){
            number.append(benefit.getBenefitNumber());
        }else {
            number.append("");
        }
        String benefitNumber = number.toString();
        switch (benefit.getBenefitCode()){
            case "020":
                benefitDef = 5;
                benefitType = 2;
                break;
            case "010":
                benefitDef = 4;
                benefitType = 2;
                break;
            case "083":
                benefitDef = 1;
                benefitType = 2;
                break;
            case "082":
                benefitDef = 2;
                benefitType = 2;
                break;
            case "081":
                benefitDef = 3;
                benefitType = 2;
                break;
            case "060":
                benefitDef = 10;
                benefitType = 2;
                break;
            case "10":
                benefitDef = 13;
                benefitType = 2;
                break;
            case "4":
                benefitDef = 17;
                benefitType = 2;
                break;
            case "890":
                benefitDef = 28;
                benefitType = 7;
                break;
            case "5":
                benefitDef = 18;
                benefitType = 2;
                break;
            case "012":
                  benefitDef = 61;
                  benefitType = 2;
                break;
            case "050":
                benefitDef = 8;
                benefitType = 2;
                break;
            case "062":
                benefitDef = 62;
                benefitType = 2;
                break;
            case "094":
                benefitDef = 67;
                benefitType = 2;
                break;

            case "030":
                benefitDef = 6;
                benefitType = 2;
                break;
            case "084":
                benefitDef = 12;
                benefitType = 2;
                break;
            case "123":
                benefitDef = 66;
                benefitType = 2;
                break;
            case "124":
                benefitDef = 66;
                benefitType = 2;
                break;
            case "120":
                benefitDef = 9;
                benefitType = 2;
                break;
            case "040":
                benefitDef = 7;
                benefitType = 2;
                break;
            case "092":
                benefitDef = 18;
                benefitType = 2;
                break;
            case "093":
                benefitDef = 64;
                benefitType = 2;
                break;
            case "098":
                benefitDef = 55;
                benefitType = 2;
                break;
            case "111":
                benefitDef = 65;
                benefitType = 2;
                break;
            case "112":
                benefitDef = 17;
                benefitType = 2;
                break;
            case "113":
                benefitDef = 13;
                benefitType = 2;
                break;
            case "000":
                benefitDef = 27;
                benefitType = 5;
                break;
            case "501":
                benefitDef = 32;
                benefitType = 9;
                break;
            case "502":
                benefitDef = 33;
                benefitType = 9;
                break;
            case "503":
                benefitDef = 34;
                benefitType = 9;
                break;
            case "140":
                benefitDef = 56;
                benefitType = 2;
                break;

            case "011":
                benefitDef = 54;
                benefitType = 2;
                break;

            case "131":
                benefitDef = 58;
                benefitType = 2;
                break;

            case "715":
                benefitDef = 29;
                benefitType = 9;
                break;


            case "510":
                benefitDef = 52;
                benefitType = 9;
                break;


            case "531":
                benefitDef = 52;
                benefitType = 9;
                break;

            case "064":
                benefitDef = 57;
                benefitType = 2;
                break;
            case "150":
                benefitDef = 59;
                benefitType = 2;
                break;
            case "091":
                benefitDef = 63;
                benefitType = 2;
                break;
            /*('093', '012', '062', '091', '111', '123');*/
            case "132":
                benefitDef = 60;
                benefitType = 2;
                break;

        } //id, created_dt, benefit_def_id, benefit_type_id, patient_id, doc_issuer, doc_issuer_dt, doc_name, doc_number, from_dt, to_dt
        jdbcTemplate.update(sql, new Object[] {benefitDef, benefitType, benefit.getId(), benefit.getBenefitIssuer(), benefit.getBenefitGiven(), benefit.getBenefitName(), benefitNumber, benefit.getBenefitStarDate(), benefit.getBenefitEndDate()});
    }


    public List<String> searchCodes(){

        String sql = "SELECT code from pci_benefit_definition ORDER BY id";
        return (List<String>) jdbcTemplate.queryForList(sql, String.class);
    }


    public void nppAdd(Entity entity){
        List<Indiv> indiv = null;
        String npp = "npp" + entity.getNpp();
        String sql = "update pci_patient set note = ? where id = ?";
        jdbcTemplate.update(sql, npp, entity.getId());
        }

    }


