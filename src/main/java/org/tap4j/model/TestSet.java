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

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.tap4j.util.StatusValues;

/**
 * A Test Set is the top element in a TAP File. It holds references to the 
 * Header, Plan, List of Test Results and the rest of elements in TAP spec.
 * 
 * @author Bruno P. Kinoshita - http://www.kinoshita.eti.br
 * @since 1.0
 */
public class TestSet 
implements Serializable
{
	private static final long serialVersionUID = 1L;

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	/**
	 * TAP Header.
	 */
	private Header header;
	
	/**
	 * TAP Plan.
	 */
	private Plan plan;
	
	/**
	 * List of TAP Lines.
	 */
	private List<TapResult> tapLines = new LinkedList<TapResult>();
	
	/**
	 * List of Test Results.
	 */
	private List<TestResult> testResults = new LinkedList<TestResult>();
	
	/**
	 * List of Bail Outs.
	 */
	private List<BailOut> bailOuts = new LinkedList<BailOut>();
	
	/**
	 * List of comments.
	 */
	private List<Comment> comments = new LinkedList<Comment>();
	
	/**
	 * TAP Footer.
	 */
	private Footer footer;
	
	/**
	 * Default constructor.
	 */
	public TestSet()
	{
		super();
	}
	
	/**
	 * @return TAP Header.
	 */
	public Header getHeader()
	{
		return this.header;
	}
	
	/**
	 * @param header TAP Header.
	 */
	public void setHeader( Header header )
	{
		this.header = header;
	}
	
	/**
	 * @return TAP Plan.
	 */
	public Plan getPlan()
	{
		return this.plan;
	}
	
	/**
	 * @param plan TAP Plan.
	 */
	public void setPlan( Plan plan )
	{
		this.plan = plan;
	}
	
	/**
	 * @return List of TAP Lines. These lines may be either a TestResult 
	 * or a BailOut.
	 */
	public List<TapResult> getTapLines()
	{
		return this.tapLines;
	}
	
	/**
	 * @return List of Test Results.
	 */
	public List<TestResult> getTestResults()
	{
		return this.testResults;
	}
	
	/**
	 * @return List of Bail Outs.
	 */
	public List<BailOut> getBailOuts()
	{
		return this.bailOuts;
	}
	
	/**
	 * @return List of Comments.
	 */
	public List<Comment> getComments()
	{
		return this.comments;
	}
	
	/**
	 * Adds a new TAP Line.
	 * 
	 * @param tapLine TAP Line.
	 * @return True if the TAP Line could be added into the list successfully.
	 */
	public boolean addTapLine( TapResult tapLine )
	{
		return this.tapLines.add( tapLine );
	}
	
	/**
	 * Adds a TestResult into the list of TestResults. If the TestResult 
	 * Test Number is null or less than or equals to zero it is changed to 
	 * the next Test Number in the sequence.
	 * 
	 * @param testResult TAP TestResult.
	 * @return Whether could add to TestResult list or not.
	 */
	public boolean addTestResult( TestResult testResult )
	{
		if ( testResult.getTestNumber() == null || testResult.getTestNumber() <= 0 )
		{
			testResult.setTestNumber( this.testResults.size() + 1 );
		}
		this.testResults.add( testResult );
		return this.tapLines.add( testResult );
	}
	
	/**
	 * @param bailOut Bail Out.
	 * @return Whether could add to BailOut list or not.
	 */
	public boolean addBailOut( BailOut bailOut )
	{
		this.bailOuts.add( bailOut );
		return this.tapLines.add( bailOut );
	}
	
	/**
	 * @param comment Comment.
	 * Whether could add to Comment list or not.
	 */
	public boolean addComment( Comment comment )
	{
		this.comments.add( comment );
		return this.tapLines.add( comment );
	}
	
	/**
	 * Removes a TAP Line from the list.
	 * 
	 * @param tapLine TAP Line object.
	 * @return True if could successfully remove the TAP Line from the list.
	 */
	protected boolean removeTapLine( TapResult tapLine )
	{
		return this.tapLines.remove( tapLine );
	}
	
	/**
	 * Removes a Test Result from the list.
	 * 
	 * @param testResult Test Result.
	 * @return True if could successfully remove the Test Result from the list.
	 */
	public boolean removeTestResult( TestResult testResult )
	{
		boolean flag = false;
		if ( this.tapLines.remove( testResult ) )
		{
			this.testResults.remove( testResult );
			flag = true;
		}
		return flag;
	}
	
	/**
	 * Removes a Bail Out from the list.
	 * 
	 * @param bailOut Bail Out object.
	 * @return True if could successfully remove the Bail Out from the list.
	 */
	public boolean removeBailOut( BailOut bailOut )
	{
		boolean flag = false;
		if ( this.tapLines.remove( bailOut ) )
		{
			this.bailOuts.remove( bailOut );
			flag = true;
		}
		return flag;
	}
	
	/**
	 * Removes a Comment from the list.
	 * 
	 * @param comment Comment.
	 * @return True if could successfully remove the Comment from the list.
	 */
	public boolean removeComment( Comment comment )
	{
		boolean flag = false;
		if ( this.tapLines.remove( comment ) )
		{
			this.comments.remove( comment );
			flag = true;
		}
		return flag;
	}
	
	/**
	 * @return Number of TAP Lines. It includes Test Results, Bail Outs and 
	 * Comments (the footer is not included).
	 */
	public int getNumberOfTapLines()
	{
		return this.tapLines.size();
	}
	
	/**
	 * @return Number of Test Results.
	 */
	public int getNumberOfTestResults()
	{
		return this.testResults.size();
	}
	
	/**
	 * @return Number of Bail Outs.
	 */
	public int getNumberOfBailOuts()
	{
		return this.bailOuts.size();
	}
	
	/**
	 * @return Number of Comments.
	 */
	public int getNumberOfComments()
	{
		return this.comments.size();
	}
	
	/**
	 * @return Footer
	 */
	public Footer getFooter()
	{
		return this.footer;
	}
	
	/**
	 * @param footer Footer
	 */
	public void setFooter( Footer footer )
	{
		this.footer = footer;
	}
	
	/**
	 * @return True if it has any Bail Out statement, false otherwise.
	 */
	public boolean hasBailOut()
	{
		boolean isBailOut = false;
		
		for ( TapResult tapLine : tapLines )
		{
			if ( tapLine instanceof BailOut )
			{
				isBailOut = true;
				break;
			}
		}
		
		return isBailOut;
	}
	
	/* (non-Javadoc)
	 * @see org.tap4j.TapConsumer#containsOk()
	 */
	public Boolean containsOk()
	{
		Boolean containsOk = false;
		
		for( TestResult testResult : this.testResults )
		{
			if ( testResult.getStatus().equals( StatusValues.OK ) )
			{
				containsOk = true;
				break;
			}
		}
		
		return containsOk;
	}
	
	/* (non-Javadoc)
	 * @see org.tap4j.TapConsumer#containsNotOk()
	 */
	public Boolean containsNotOk()
	{
		Boolean containsNotOk = false;
		
		for( TestResult testResult : this.testResults )
		{
			if ( testResult.getStatus().equals( StatusValues.NOT_OK ) )
			{
				containsNotOk = true;
				break;
			}
		}
		
		return containsNotOk;
	}

	/* (non-Javadoc)
	 * @see org.tap4j.TapConsumer#containsBailOut()
	 */
	public Boolean containsBailOut()
	{
		return this.bailOuts.size() > 0;
	}
	
	/* (non-Javadoc)
	 * @see org.tap4j.TapConsumer#getTestResult(java.lang.Integer)
	 */
	public TestResult getTestResult( Integer testNumber )
	{
		TestResult foundTestResult = null;
		
		for( TestResult testResult : this.testResults )
		{
			if ( testResult.getTestNumber() != null && testResult.getTestNumber().equals(testNumber) )
			{
				foundTestResult = testResult;
				break;
			}
		}
		
		return foundTestResult;
	}
	
	/**
	 * @return Next test number. 
	 */
	public int getNextTestNumber()
	{
		return (this.testResults.size()+1);
	}

	/**
	 * @return Summary of the TAP Stream.
	 */
	public String getSummary()
	{
		final StringBuilder summary = new StringBuilder();
		
		if ( this.header != null )
		{
			summary.append( this.header.toString() );
			summary.append( LINE_SEPARATOR );
		}
		
		if ( this.plan != null )
		{
			summary.append( this.plan.toString() );
			summary.append( LINE_SEPARATOR );
		}
		
		Integer numberOfTestResults = this.getNumberOfTestResults();
		
		summary.append(numberOfTestResults);
		summary.append(" tests.");
		
		if( this.getNumberOfBailOuts() > 0 )
		{
			summary.append( "Contains Bail out!");
			summary.append( LINE_SEPARATOR );
		}
		
		if ( this.footer != null )
		{
			summary.append( "Footer: " );
			summary.append( footer.getText() );
			summary.append( LINE_SEPARATOR );
		}
		
		return summary.toString();
	}
	
	/**
	 * @return Details of the TAP Stream.
	 */
	public String getDetails()
	{
		return this.toString();
	}
	
	@Override
	public String toString()
	{
		final StringBuilder sb = new StringBuilder();
		
		if ( header != null )
		{
			sb.append( header.toString() );
			sb.append ( LINE_SEPARATOR );
		}
		
		sb.append( plan.toString() );
		sb.append ( LINE_SEPARATOR );
		
		for( TapResult tapLine : tapLines )
		{
			sb.append( tapLine.toString() );
			sb.append ( LINE_SEPARATOR );
		}
		
		if ( footer != null )
		{
			sb.append( footer.toString() );
		}
		
		return sb.toString();
	}
	
}
