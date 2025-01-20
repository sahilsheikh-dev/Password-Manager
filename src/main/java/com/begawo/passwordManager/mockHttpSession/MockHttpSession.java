package com.begawo.passwordManager.mockHttpSession;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class MockHttpSession implements HttpSession {

	private final Map<String, Object> attributes = new HashMap<>();

	@Override
	public Object getAttribute(String name) {
		return attributes.get(name);
	}

	@Override
	public void setAttribute(String name, Object value) {
		attributes.put(name, value);
	}

	@Override
	public void removeAttribute(String name) {
		attributes.remove(name);
	}

	// Other methods from HttpSession can be left unimplemented or you can add mock
	// implementations if needed.
	@Override
	public String getId() {
		return "mock-session-id";
	}

	@Override
	public long getCreationTime() {
		return System.currentTimeMillis();
	}

	@Override
	public long getLastAccessedTime() {
		return System.currentTimeMillis();
	}

	// Implement other HttpSession methods as needed, for simplicity we are leaving
	// out many.
	@Override
	public int getMaxInactiveInterval() {
		return 0;
	}

	@Override
	public void setMaxInactiveInterval(int interval) {
		// No-op
	}

	@Override
	public javax.servlet.ServletContext getServletContext() {
		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public javax.servlet.http.HttpSessionContext getSessionContext() {
		return null;
	}

	@Override
	public Object getValue(String name) {
		return getAttribute(name);
	}

	@Override
	public String[] getValueNames() {
		return new String[0];
	}

	@Override
	public void invalidate() {
		// No-op for mock session
	}

	@Override
	public boolean isNew() {
		return false;
	}

	@Override
	public Enumeration<String> getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String name, Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeValue(String name) {
		// TODO Auto-generated method stub

	}
}
