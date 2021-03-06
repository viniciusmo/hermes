package com.hermes.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.hermes.tools.Log;

public class AnnotatedActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		try {
			removeTitleIfIsPresent();
			fillViewWithLayout();
			fillFieldsWithSpecificViewId();
		} catch (IllegalArgumentException e) {
			Log.e(e.getMessage());
		} catch (IllegalAccessException e) {
			Log.e(e.getMessage());
		}
	}

	private void removeTitleIfIsPresent() {
		NoTitle title = getClass().getAnnotation(NoTitle.class);
		if (title != null) {
			requestWindowFeature(Window.FEATURE_NO_TITLE);
		}
	}

	private void fillViewWithLayout() {
		Layout view = getClass().getAnnotation(Layout.class);
		setContentView(view.value());
	}

	private void fillFieldsWithSpecificViewId()
			throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = getClass().getDeclaredFields();
		for (Field field : fields) {
			Annotation[] annotations = field.getAnnotations();
			verifyAndFillViewWithId(field, annotations);
		}
	}

	private void verifyAndFillViewWithId(Field field, Annotation[] annotations)
			throws IllegalArgumentException, IllegalAccessException {
		for (Annotation annotation : annotations) {
			if (annotation instanceof Id) {
				Log.i(field.getName());
				field.setAccessible(true);
				field.set(this, findViewById(((Id) annotation).value()));
			}
		}
	}
}
