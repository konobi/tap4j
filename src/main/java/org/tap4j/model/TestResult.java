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

import org.tap4j.util.StatusValues;
import org.tap4j.util.Util;

/**
 * @author Bruno P. Kinoshita - http://www.kinoshita.eti.br
 * @since 1.0
 */
public class TestResult 
extends TapResult
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Test Status (OK, NOT OK).
	 */
	private StatusValues status;

	/**
	  * Test Number.
	  */
	private Integer testNumber;
	
	/**
	 * Description of the test.
	 */
	private String description;
	
	/**
	 * Directive of the test (TO DO, SKIP).
	 */
	private Directive directive;

	/**
	 * Comment.
	 */
	private Comment comment;
	
	public TestResult()
	{
		super();
		this.status = StatusValues.NOT_OK;
		this.testNumber = -1;
	}
	
	/**
	 * Constructor with parameter.
	 * 
	 * @param testStatus Status of the test.
	 * @param testNumber Number of the test.
	 */
	public TestResult( StatusValues testStatus, Integer testNumber )
	{
		super();
		this.status = testStatus;
		this.testNumber = testNumber;
	}

	/**
	 * @return Status of the test.
	 */
	public StatusValues getStatus()
	{
		return this.status;
	}

	/**
	 * @param status Status of the test.
	 */
	public void setStatus( StatusValues status )
	{
		this.status = status;
	}
	
	/**
	 * @return Test Number.
	 */
	public Integer getTestNumber()
	{
		return this.testNumber;
	}
	
	/**
	 * @param testNumber Test Number.
	 */
	public void setTestNumber( Integer testNumber )
	{
		this.testNumber = testNumber;
	}
	
	/**
	 * @return Test description.
	 */
	public String getDescription()
	{
		return this.description;
	}
	
	/**
	 * @param description Test description.
	 */
	public void setDescription( String description )
	{
		this.description = description;
	}
	
	/**
	 * @return Optional Directive.
	 */
	public Directive getDirective()
	{
		return this.directive;
	}
	
	/**
	 * @param directive Optional Directive.
	 */
	public void setDirective( Directive directive )
	{
		this.directive = directive;
	}
	
	/**
	 * @return The comment set for this Test Result.
	 */
	public Comment getComment()
	{
		return this.comment;
	}
	
	/**
	 * @param comment Comment.
	 */
	public void setComment( Comment comment )
	{
		this.comment = comment;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append( status );
		
		Util.appendIfNotNull(sb, " ", testNumber, null);
		Util.appendIfNotNull(sb, " ", description, null);
		
		Util.appendIfNotNull(sb, null, directive, null);
		
		Util.appendIfNotNull(sb, " ", comment, null);
		
		return sb.toString();
	}

}
