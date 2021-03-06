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

/**
 * TAP Header. Each TAP File has at most one header in the beginning of it. The 
 * only thing that can precede the Header are comments. However a Header is not 
 * required in a TAP File (i.e. the Header is optional).
 * 
 * @author Bruno P. Kinoshita - http://www.kinoshita.eti.br
 * @since 1.0
 */
public class Header 
extends AbstractTapElementDiagnostic
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * TAP file version.
	 */
	private Integer version;
	
	/**
	 * Header optional comment.
	 */
	private Comment comment;
	
	/**
	 * Constructor with parameter.
	 * 
	 * @param version TAP file version.
	 */
	public Header( Integer version )
	{
		super();
		this.version = version;
	}
	
	/**
	 * @return The TAP file version.
	 */
	public Integer getVersion()
	{
		return this.version;
	}
	
	/**
	 * @return Header comment.
	 */
	public Comment getComment()
	{
		return this.comment;
	}
	
	/**
	 * Sets a comment into the Header.
	 * 
	 * @param comment Header comment.
	 */
	public void setComment( Comment comment )
	{
		this.comment = comment;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append( "TAP version " );
		sb.append( this.version );
		
		if ( this.comment != null )
		{
			sb.append ( ' ' );
			sb.append( this.comment.toString() );
		}
		
		return sb.toString();
	}
	
}
