import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

//Brandon and Naomi
//Failed test cases
public class IntBoardTest {
	IntBoard board;
	
	@Before 
	public void setUp(){
		board = new IntBoard();	
		board.calcAdjacencies();
	}
	
	@Test
	public void testcalcIndex() {
		Assert.assertEquals(0, board.calcIndex(0, 0));
		Assert.assertEquals(7, board.calcIndex(1, 3));
		Assert.assertEquals(10, board.calcIndex(2, 2));
		Assert.assertEquals(13, board.calcIndex(3, 1));
	}
	
	@Test
	public void testAdjacency0() {
		LinkedList<Integer> testList = board.getAdjList(0);
		Assert.assertTrue(testList.contains(4));
		Assert.assertTrue(testList.contains(1));
		Assert.assertEquals(2, testList.size());
	}

	@Test
	public void testAdjacency15() {
		LinkedList<Integer> testList = board.getAdjList(15);
		Assert.assertTrue(testList.contains(11));
		Assert.assertTrue(testList.contains(14));
		Assert.assertEquals(2, testList.size());
	}
	
	@Test
	public void testAdjacency7() {
		LinkedList<Integer> testList = board.getAdjList(7);
		Assert.assertTrue(testList.contains(3));
		Assert.assertTrue(testList.contains(6));
		Assert.assertTrue(testList.contains(11));
		Assert.assertEquals(3, testList.size());
	}
	
	@Test
	public void testAdjacency8() {
		LinkedList<Integer> testList = board.getAdjList(8);
		Assert.assertTrue(testList.contains(4));
		Assert.assertTrue(testList.contains(9));
		Assert.assertTrue(testList.contains(12));
		Assert.assertEquals(3, testList.size());
	}
	
	@Test
	public void testAdjacency5() {
		LinkedList<Integer> testList = board.getAdjList(5);
		Assert.assertTrue(testList.contains(4));
		Assert.assertTrue(testList.contains(1));
		Assert.assertTrue(testList.contains(6));
		Assert.assertTrue(testList.contains(9));
		Assert.assertEquals(4, testList.size());
	}
	
	@Test
	public void testAdjacency10() {
		LinkedList<Integer> testList = board.getAdjList(10);
		Assert.assertTrue(testList.contains(6));
		Assert.assertTrue(testList.contains(9));
		Assert.assertTrue(testList.contains(11));
		Assert.assertTrue(testList.contains(14));
		Assert.assertEquals(4, testList.size());
	}
	
	@Test
	public void testTargets0_3()
	{
		board.startTargets(0, 3);
		Set targets= board.getTargets();
		Assert.assertEquals(6, targets.size());
		Assert.assertTrue(targets.contains(12));
		Assert.assertTrue(targets.contains(9));
		Assert.assertTrue(targets.contains(1));
		Assert.assertTrue(targets.contains(6));
		Assert.assertTrue(targets.contains(3));
		Assert.assertTrue(targets.contains(4));
	}
	
	@Test
	public void testTargets4_2()
	{
		board.startTargets(4, 2);
		Set targets= board.getTargets();
		Assert.assertEquals(4, targets.size());
		Assert.assertTrue(targets.contains(12));
		Assert.assertTrue(targets.contains(9));
		Assert.assertTrue(targets.contains(1));
		Assert.assertTrue(targets.contains(6));
	}
	
	@Test
	public void testTargets11_1()
	{
		board.startTargets(11, 1);
		Set targets= board.getTargets();
		Assert.assertEquals(3, targets.size());
		Assert.assertTrue(targets.contains(7));
		Assert.assertTrue(targets.contains(10));
		Assert.assertTrue(targets.contains(15));
	}
	
	@Test
	public void testTargets13_6()
	{
		board.startTargets(13, 6);
		Set targets= board.getTargets();
		Assert.assertEquals(7, targets.size());
		Assert.assertTrue(targets.contains(0));
		Assert.assertTrue(targets.contains(2));
		Assert.assertTrue(targets.contains(5));
		Assert.assertTrue(targets.contains(7));
		Assert.assertTrue(targets.contains(8));
		Assert.assertTrue(targets.contains(10));
		Assert.assertTrue(targets.contains(15));
	}
	
	@Test
	public void testTargets2_4()
	{
		board.startTargets(2, 4);
		Set targets= board.getTargets();
		Assert.assertEquals(7, targets.size());
		Assert.assertTrue(targets.contains(0));
		Assert.assertTrue(targets.contains(13));
		Assert.assertTrue(targets.contains(5));
		Assert.assertTrue(targets.contains(7));
		Assert.assertTrue(targets.contains(8));
		Assert.assertTrue(targets.contains(10));
		Assert.assertTrue(targets.contains(15));
	}
	
	@Test
	public void testTargets9_2()
	{
		board.startTargets(9, 2);
		Set targets= board.getTargets();
		Assert.assertEquals(6, targets.size());
		Assert.assertTrue(targets.contains(1));
		Assert.assertTrue(targets.contains(11));
		Assert.assertTrue(targets.contains(14));
		Assert.assertTrue(targets.contains(6));
		Assert.assertTrue(targets.contains(12));
		Assert.assertTrue(targets.contains(4));
	}
	
	@Test
	public void testTargets15_5()
	{
		board.startTargets(15, 5);
		Set targets= board.getTargets();
		System.out.println("15_5" + targets);
		Assert.assertEquals(8, targets.size());
		Assert.assertTrue(targets.contains(11));
		Assert.assertTrue(targets.contains(12));
		Assert.assertTrue(targets.contains(9));
		Assert.assertTrue(targets.contains(1));
		Assert.assertTrue(targets.contains(6));
		Assert.assertTrue(targets.contains(3));
		Assert.assertTrue(targets.contains(4));
		Assert.assertTrue(targets.contains(14));
	}
}
