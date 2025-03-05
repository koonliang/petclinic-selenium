package com.auto.framework.actions;

import com.auto.framework.interfaces.IElementVerification;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
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
