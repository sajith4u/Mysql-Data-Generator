package hms.mchoice.rewards.data.domain;

import java.math.BigInteger;

/**
 * Created by sajithv on 10/6/15.
 */
public class RewardsSummaryDomain {
    private long dateId;
    private BigInteger campaignId;
    private int bonusType;
    private String offerStatus;
    private int cycleNo;
    private double bonusValue;
    private int bonusCount;

    public long getDateId() {
        return dateId;
    }

    public void setDateId(long dateId) {
        this.dateId = dateId;
    }

    public BigInteger getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(BigInteger campaignId) {
        this.campaignId = campaignId;
    }

    public int getBonusType() {
        return bonusType;
    }

    public void setBonusType(int bonusType) {
        this.bonusType = bonusType;
    }

    public String getOfferStatus() {
        return offerStatus;
    }

    public void setOfferStatus(String offerStatus) {
        this.offerStatus = offerStatus;
    }

    public int getCycleNo() {
        return cycleNo;
    }

    public void setCycleNo(int cycleNo) {
        this.cycleNo = cycleNo;
    }

    public double getBonusValue() {
        return bonusValue;
    }

    public void setBonusValue(double bonusValue) {
        this.bonusValue = bonusValue;
    }

    public int getBonusCount() {
        return bonusCount;
    }

    public void setBonusCount(int bonusCount) {
        this.bonusCount = bonusCount;
    }

    @Override
    public String toString() {
        return "RewardsSummaryDomain{" +
                "dateId=" + dateId +
                ", campaignId=" + campaignId +
                ", bonusType=" + bonusType +
                ", offerStatus='" + offerStatus + '\'' +
                ", cycleNo=" + cycleNo +
                ", bonusValue=" + bonusValue +
                ", bonusCount=" + bonusCount +
                '}';
    }
}
