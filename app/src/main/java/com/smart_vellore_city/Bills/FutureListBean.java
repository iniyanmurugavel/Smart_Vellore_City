package com.smart_vellore_city.Bills;

public class FutureListBean {
    String consumerId,consumerBoard,operator_code,type;

    public FutureListBean( String operator_code,String consumerId, String consumerBoard, String type) {
        this.consumerId = consumerId;
        this.consumerBoard = consumerBoard;
        this.operator_code = operator_code;
        this.type = type;
    }

    public String getOperator_code() {
        return operator_code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setOperator_code(String operator_code) {
        this.operator_code = operator_code;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public String getConsumerBoard() {
        return consumerBoard;
    }

    public void setConsumerBoard(String consumerBoard) {
        this.consumerBoard = consumerBoard;
    }

    public FutureListBean(String consumerId, String consumerBoard) {
        this.consumerId = consumerId;
        this.consumerBoard = consumerBoard;

    }
}
