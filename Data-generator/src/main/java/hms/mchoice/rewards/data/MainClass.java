package hms.mchoice.rewards.data;

import hms.mchoice.rewards.data.domain.RewardsSummaryDomain;
import hms.mchoice.rewards.data.service.DbConnectivityImpl;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainClass {

    private static int minDateId = 732;
    private static int maxDateId = 1740;
    static BigInteger campaign1 = new BigInteger("20043245048216");
    static BigInteger campaign2 = new BigInteger("20043245048216");
    static BigInteger campaign3 = new BigInteger("20043245048216");
    static BigInteger campaign4 = new BigInteger("20043245048216");
    static BigInteger campaign5 = new BigInteger("20043245048216");

    static Map<Integer, BigInteger> list = new HashMap<Integer, BigInteger>();
    static int[] rewardsTypeList = {1, 2, 3, 4};
    static int[] cycleList = {1, 2, 3, 4, 5};

    public static void main(String[] args) {

        System.out.println("================== data generator started ==========");
        list.put(1, campaign1);
        list.put(2, campaign2);
        list.put(3, campaign3);
        list.put(4, campaign4);
        list.put(5, campaign5);
        int count = 0;
        DbConnectivityImpl dbConnectivity = new DbConnectivityImpl();
        for (int x = minDateId; x < maxDateId; x++) {
            for (int numOfCampaigns = 0; numOfCampaigns < list.size(); numOfCampaigns++) {

                for (int numOfRewardsType = 0; numOfRewardsType < rewardsTypeList.length; numOfRewardsType++) {
                    for (int cycleNumber = 0; cycleNumber < cycleList.length; cycleNumber++) {
                        RewardsSummaryDomain rewardsSummaryDomain = new RewardsSummaryDomain();
                        rewardsSummaryDomain.setBonusType(rewardsTypeList[numOfRewardsType]);
                        rewardsSummaryDomain.setCampaignId(list.get(numOfCampaigns));
                        rewardsSummaryDomain.setOfferStatus("APPROVED");

                        Random r = new Random();
                        double randomValue = 0 + (100 - 0) * r.nextDouble();
                        int randomNumber = r.nextInt(10 - 1) + 1;

                        rewardsSummaryDomain.setBonusValue(randomValue);
                        rewardsSummaryDomain.setCycleNo(cycleNumber);
                        rewardsSummaryDomain.setDateId(x);
                        rewardsSummaryDomain.setBonusCount(randomNumber);
                        dbConnectivity.insertRewardsData(rewardsSummaryDomain);

                        System.out.println("Called  " + count);
                        System.out.println("Data :" + rewardsSummaryDomain.toString());
                        count++;

                    }
                }

            }
        }
    }
}
