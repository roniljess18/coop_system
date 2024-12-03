package dev.rjm.models.hr;

import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXStringProperty;

public class Office extends FXModel {

    private FXStringProperty office_id;
    private FXStringProperty office_name;

    public Office(String office_id, String office_name){
        this.office_id = new FXStringProperty(office_id);
        this.office_name = new FXStringProperty(office_name);

        track_properties(this.office_id, this.office_name);
    }

    public FXStringProperty officeidProperty(){
        return office_id;
    }
    public String getOfficeId(){
        return officeidProperty().get();
    }
    public void setOfficeId(String office_id){
        officeidProperty().set(getOfficeId());
    }

    public FXStringProperty officenameProperty(){
        return office_name;
    }
    public String getOfficeName(){
        return officenameProperty().get();
    }
    public void setOfficeName(String office_name){
        officenameProperty().set(getOfficeName());
    }

    @Override
    public FXModel clone() {
        return new Office(getOfficeId(), getOfficeName());
    }

    @Override
    public void copy(FXModel arg0) {
        Office c = (Office) arg0;

        setOfficeId(c.getOfficeId());
        setOfficeName(c.getOfficeName());
    }
    
}
