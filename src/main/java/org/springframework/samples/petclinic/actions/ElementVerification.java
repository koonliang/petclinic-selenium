package org.springframework.samples.petclinic.actions;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.springframework.samples.petclinic.interfaces.IElementVerification;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ElementVerification extends ActionsBaseClass implements IElementVerification {

	@Override
	public String getTitle() {
		String title = driver.getTitle();
		log.debug("Opened Page : {}", title);
		return title;
	}
	
	@Override
	public String getText(By by) {
		String text = driver.findElement(by).getText();
		log.debug("Text Value: {}", text);
		return text;
	}


}
