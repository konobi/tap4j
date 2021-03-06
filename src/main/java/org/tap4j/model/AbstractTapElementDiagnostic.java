/*
 * The MIT License
 *
 * Copyright (c) <2010> <tap4j>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.tap4j.model;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * TAP Element that supports diagnostic information.
 * 
 * @author Bruno P. Kinoshita - http://www.kinoshita.eti.br
 * @since 1.0
 */
public abstract class AbstractTapElementDiagnostic 
implements TapElement
{
	
	private static final long serialVersionUID = 4685273196118919946L;
	/**
	 * Iterable object returned by snakeyaml.
	 */
	protected Map<String, Object> diagnostic = new LinkedHashMap<String, Object>();
	
	/* (non-Javadoc)
	 * @see org.tap4j.model.TapElement#getDiagnostic()
	 */
	public Map<String, Object> getDiagnostic() 
	{
		return this.diagnostic;
	}
	
	/* (non-Javadoc)
	 * @see org.tap4j.model.TapElement#setDiagnostic(java.lang.Iterable)
	 */
	public void setDiagnostic(Map<String, Object> diagnostic) 
	{
		this.diagnostic = diagnostic;
	}
		
}
