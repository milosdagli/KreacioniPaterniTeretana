/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainClasses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Milos
 */
public class Teretana implements GeneralDObject {

    private int idclanovi;
    private String ime;
    private String prezime;
    private String paket;
    private Date datumDo;

    public Teretana(int idclanovi, String ime, String prezime, String paket, Date datumDo) {
        this.idclanovi = idclanovi;
        this.ime = ime;
        this.prezime = prezime;
        this.paket = paket;
        this.datumDo = datumDo;
    }

    public Teretana() {
        idclanovi = 0;
        ime = "";
        prezime = "";
        paket = "";
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        Date dDatum = new Date();
        datumDo = java.sql.Date.valueOf(sm.format(dDatum));

    }

    public int getIdclanovi() {
        return idclanovi;
    }

    public void setIdclanovi(int idclanovi) {
        this.idclanovi = idclanovi;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getPaket() {
        return paket;
    }

    public void setPaket(String paket) {
        this.paket = paket;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    @Override
    public String getAtrValue() {
        return idclanovi + ", '" + ime +"' , '" + prezime+"' , '"+ paket +"' , '" + datumDo + "'";
    }

    @Override
    public String setAtrValue() {
        return "idclanovi=" + idclanovi + ", " + "ime= '" + ime + "' , " + "prezime= '" + prezime + "' , " + "paket= '" + paket + "' , " + "datumDo= " + "'" + datumDo + "'";
    }

    @Override
    public String getClassName() {
        return "clanovi";
    }

    @Override
    public String getWhereCondition() {
        return "idclanovi=" + idclanovi;
    }

    @Override
    public String getNameByColumn(int column) {
          String names[] = {"idclanovi","ime","prezime","paket","datumDo"}; 
          return names[column];
    }

    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        return new Teretana(rs.getInt("idclanovi"),rs.getString("ime"),rs.getString("prezime"),rs.getString("paket"),rs.getDate("datumDo"));
    }

   

}
