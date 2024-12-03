package dev.rjm.models.delivery;

import dev.rjm.models.sales.Supplier;
import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXDoubleProperty;
import dev.sol.core.properties.beans.FXIntegerProperty;
import dev.sol.core.properties.beans.FXObjectProperty;
import dev.sol.core.properties.beans.FXStringProperty;

public class DeliveryReceipt extends FXModel {

    private FXStringProperty DRID;
    private FXStringProperty DRNum;
    private FXObjectProperty<Supplier> supplierId;
    private FXIntegerProperty datedel;
    private FXDoubleProperty totalamt;
    private FXDoubleProperty paidamt;
    private FXIntegerProperty userid;

    public DeliveryReceipt(String DRID,
            String DRNum,
            Supplier supplierId,
            Integer datedel,
            Double totalamt,
            Double paidamt,
            Integer userid) {
        this.DRID = new FXStringProperty(DRID);
        this.DRNum = new FXStringProperty(DRNum);
        this.supplierId = new FXObjectProperty<>(supplierId);
        this.datedel = new FXIntegerProperty(datedel);
        this.totalamt = new FXDoubleProperty(totalamt);
        this.paidamt = new FXDoubleProperty(paidamt);
        this.userid = new FXIntegerProperty(userid);

        track_properties(this.DRID,
                this.DRNum,
                this.supplierId,
                this.datedel,
                this.totalamt,
                this.paidamt,
                this.userid);
    }

    // DRID
    public FXStringProperty DRIDProperty() {
        return DRID;
    }

    public String getDRID() {
        return DRIDProperty().get();
    }

    public void setDRID(String DRID) {
        DRIDProperty().set(DRID);
    }

    //DRNum
    public FXStringProperty DRNumProperty() {
        return DRNum;
    }

    public String getDRNum() {
        return DRNumProperty().get();
    }

    public void setDRNum(String DRNum) {
        DRNumProperty().set(DRNum);
    }

    // supplierId
    public FXObjectProperty<Supplier> supplierProperty(){
        return supplierId;
    }
    public Supplier getSupplierId(){
        return supplierProperty().get();
    }
    public void setSupplierId(Supplier supplierId){
        supplierProperty().set(supplierId);
    }

    //
    

    @Override
    public FXModel clone() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clone'");
    }

    @Override
    public void copy(FXModel arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'copy'");
    }

}
