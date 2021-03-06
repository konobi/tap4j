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

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Bruno P. Kinoshita - http://www.kinoshita.eti.br
 * @since 1.0
 */
public class TestTAPHeader 
{

	protected Header header;
	
	protected final static Integer TAP_VERSION = 13;
	
	@BeforeMethod
	public void setUp()
	{
		this.header = new Header( TAP_VERSION );
	}
	
	@Test
	public void testHeader()
	{
		Assert.assertNotNull( this.header );
		
		Assert.assertEquals( this.header.getVersion(), TestTAPHeader.TAP_VERSION );
		
		final String expectedOutput = "TAP version " + TestTAPHeader.TAP_VERSION ;
		
		String toStringResult = this.header.toString();
		
		Assert.assertEquals( expectedOutput, toStringResult );
	}
	
	@Test
	public void testComment()
	{
		this.header.setComment( new Comment("Header's comment.") );
		
		Assert.assertNotNull( this.header.getComment() );
		
		Assert.assertEquals( this.header.getComment().getText(), "Header's comment.");
		
		Assert.assertEquals( this.header.toString(), "TAP version " + TAP_VERSION + " # Header's comment.");
	}
	
}
