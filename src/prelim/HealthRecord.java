package prelim;

import javax.imageio.IIOException;
import java.io.*;
import java.text.*;
import java.util.*;

public class HealthRecord {

    private int code;
    private String sex;
    private Date date;
    private String status;
    private String community;
    private String parish;
    private double latitude;
    private double longitude;

    public HealthRecord(int code, String sex, Date date, String status, String community, String parish, double latitude, double longitude) {
        this.code = code;
        this.sex = sex;
        this.date = date;
        this.status = status;
        this.community = community;
        this.parish = parish;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getParish() {
        return parish;
    }

    public void setParish(String parish) {
        this.parish = parish;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        DateFormat outputFormatter = new SimpleDateFormat("yyyy/MM/dd");
        String output = outputFormatter.format(date);
        return String.format("| %5d | %3s | %10s | %10s | %30s | %15s | %13f | %13f |",
                code, sex, output, status, community, parish, latitude, longitude);
    }
}
