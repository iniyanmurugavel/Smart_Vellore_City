package com.smart_vellore_city.About.ElectedRepresentatives.Model;

public class ElectedRep_Model  {
   private String constituency;
   private String memberName;
   private String partyName;

    public ElectedRep_Model(String constituency, String memberName, String partyName) {
        this.constituency = constituency;
        this.memberName = memberName;
        this.partyName = partyName;
    }

    public String getConstituency() {
        return constituency;
    }

    public void setConstituency(String constituency) {
        this.constituency = constituency;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }
}
