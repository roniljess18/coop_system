package dev.rjm.data;

import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import dev.rjm.App;
import dev.rjm.models.enums.CivilStatus;
import dev.rjm.models.hr.Member;
import dev.sol.db.DBParam;
import dev.sol.db.DBService;

public class MemberDAO {
    public static String TABLE = "member";
    public static final DBService DB = App.DB_COOP;

    private static Member data(CachedRowSet crs) {
        try {
            Integer memberID = crs.getInt("memberID");
            String Lname = crs.getString("Lname");
            String Fname = crs.getString("Fname");
            String Mname = crs.getString("Mname");
            String birthDate = crs.getString("DateofBirth");
            String birthplace = crs.getString("PlaceofBirth");
            //CivilStatus civil_status = CivilStatus.valueOf(crs.getString("Status").toUpperCase().trim());
            String homeAddress = crs.getString("CurrentAddress");
            String occupation = crs.getString("Occupation");
            Integer office = crs.getInt("OfficeID");
            double salary = crs.getDouble("Salary");
            String sourceofincome = crs.getString("SourceofIncome");
            String relative = crs.getString("NearestRelative");
            String relationship = crs.getString("Relationship");
            String dependent = crs.getString("Dependent");
            Integer stockshare = crs.getInt("StockShare");
            long stockamount = crs.getLong("StockAmount");
            long stockpaid = crs.getLong("StockPaid");
            long AmountPaid = crs.getLong("AmountPaid");

             CivilStatus civil_status = CivilStatus.values()[crs.getInt("Status")];

            return new Member(memberID,
                    Lname,
                    Fname,
                    Mname,
                    birthDate,
                    birthplace,
                    civil_status,
                    homeAddress,
                    occupation,
                    office,
                    salary,
                    sourceofincome,
                    relative,
                    relationship,
                    dependent,
                    stockshare,
                    stockamount,
                    stockpaid,
                    AmountPaid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static DBParam[] paramlist(Member member) {
        List<DBParam> paramlist = new LinkedList<>();
        paramlist.add(new DBParam(Types.INTEGER, "memberID", member.getMemberID()));
        paramlist.add(new DBParam(Types.VARCHAR, "Lname", member.getLname()));
        paramlist.add(new DBParam(Types.VARCHAR, "Fname", member.getFname()));
        paramlist.add(new DBParam(Types.VARCHAR, "Mname", member.getMname()));
        paramlist.add(new DBParam(Types.VARCHAR, "DateofBirth", member.getBirthDate()));
        paramlist.add(new DBParam(Types.VARCHAR, "PlaceofBirth", member.getBirthPlace()));
        //paramlist.add(new DBParam(Types.INTEGER, "Status", member.getCivil_Status()));
        paramlist.add(new DBParam(Types.VARCHAR, "CurrentAddress", member.getHomeAddress()));
        paramlist.add(new DBParam(Types.VARCHAR, "Occupation", member.getOccupation()));
        paramlist.add(new DBParam(Types.INTEGER, "OfficeID", member.getOffice()));
        paramlist.add(new DBParam(Types.DECIMAL, "Salary", member.getSalary()));
        paramlist.add(new DBParam(Types.VARCHAR, "SourceofIncome", member.getSourceOfIncome()));
        paramlist.add(new DBParam(Types.VARCHAR, "NearestRelative", member.getRelative()));
        paramlist.add(new DBParam(Types.VARCHAR, "Relationship", member.getRelationship()));
        paramlist.add(new DBParam(Types.VARCHAR, "Dependemt", member.getDependent()));
        paramlist.add(new DBParam(Types.INTEGER, "StockShare", member.getStockshare()));
        paramlist.add(new DBParam(Types.DECIMAL, "StockAmount", member.getStockAmount()));
        paramlist.add(new DBParam(Types.INTEGER, "StockPaid", member.getStockPaid()));
        paramlist.add(new DBParam(Types.DECIMAL, "AmountPaid", member.getAmountPaid()));
       //paramlist.add(new DBParam(Types.INTEGER, "Status", CivilStatus.valueOf(member.getCivil_Status().toUpperCase()).ordinal()));

        return paramlist.toArray(new DBParam[0]);
    }

    public static List<Member> getMemberList() {
        CachedRowSet crs = DB.select_all(TABLE);
        List<Member> list = new LinkedList<>();

        try {
            while (crs.next()) {
                Member member = data(crs);
                if (member != null)
                    ;
                list.add(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return list;
    }

    public static void insert(Member member) {
        DB.insert(TABLE, paramlist(member));
    }

    public static void delete(Member member) {
        DB.delete(TABLE, new DBParam(Types.INTEGER, "memberID", member.getMemberID()));
    }

}
