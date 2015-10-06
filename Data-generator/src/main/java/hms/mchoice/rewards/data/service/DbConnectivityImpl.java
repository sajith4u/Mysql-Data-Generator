package hms.mchoice.rewards.data.service;

import com.mysql.jdbc.Statement;
import hms.mchoice.rewards.data.domain.RewardsSummaryDomain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by sajithv on 10/6/15.
 */
public class DbConnectivityImpl implements DbConnectivity {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/vck_rewards";
    static final String USER = "root";
    static final String PASS = "sajithv";
    Connection conn = null;
    Statement stmt = null;

    public DbConnectivityImpl(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = (Statement) conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void insertRewardsData(RewardsSummaryDomain rewardsSummaryDomain) {
        System.out.println("-------------- prepering for insert data ------------");
        String sql = "INSERT INTO rewards_summary " +
                "VALUES ("+rewardsSummaryDomain.getDateId()+","+rewardsSummaryDomain.getCampaignId()+","
                +rewardsSummaryDomain.getBonusType()+","+rewardsSummaryDomain.getOfferStatus()+","+rewardsSummaryDomain.getCycleNo()+
                ","+rewardsSummaryDomain.getBonusValue()+","+rewardsSummaryDomain.getBonusCount()+")";
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertCampaignWinnerData() {

    }

    public void connectionClose(){
        try{
            if(stmt!=null)
                conn.close();
        }catch(SQLException se){
        }
        try{
            if(conn!=null)
                conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }
    }
}
