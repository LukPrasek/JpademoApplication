package pl.lukaszprasek.jpademo.models.forms;

import javax.validation.constraints.NotEmpty;

public class ButtonForm {
    @NotEmpty
    private String phase;

}
