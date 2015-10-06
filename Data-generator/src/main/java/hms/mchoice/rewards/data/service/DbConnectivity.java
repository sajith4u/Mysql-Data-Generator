package hms.mchoice.rewards.data.service;

import hms.mchoice.rewards.data.domain.RewardsSummaryDomain;

/**
 * Created by sajithv on 10/6/15.
 */
public interface DbConnectivity {

    public void insertRewardsData(RewardsSummaryDomain rewardsSummaryDomain);

    public void insertCampaignWinnerData();

}
