package org.springframework.samples.petclinic.interfaces;

import org.openqa.selenium.By;

public interface IElementVerification {
	public String getTitle();

	public String getText(By by);

}
