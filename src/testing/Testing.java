package testing;

import factory.Factory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.*;


public class Testing {

    @Test
    // test on list of panels from the email

    public void testOnDefaultSet() {
        List<int[]> testCase = new ArrayList<>(9);
        int[] pair1 = {2, 4};
        testCase.add(pair1);
        int[] pair2 = {2, 3};
        testCase.add(pair2);
        int[] pair3 = {1, 3};
        testCase.add(pair3);
        int[] pair4 = {2, 2};
        testCase.add(pair4);
        int[] pair5 = {3, 5};
        testCase.add(pair5);
        int[] pair6 = {1, 2};
        testCase.add(pair6);
        int[] pair7 = {3, 4};
        testCase.add(pair7);
        int[] pair8 = {1, 4};
        testCase.add(pair8);
        int[] pair9 = {2, 5};
        testCase.add(pair9);
        List<int[]> result = new ArrayList<>(3);
        result.add(pair2);
        result.add(pair2);
        result.add(pair4);
        Assert.assertEquals(Arrays.deepToString(new Factory(testCase, 12).getResult().toArray()), Arrays.deepToString(result.toArray()));
    }

    @Test
    // test on one panel with impossible volume

    public void testOnOnePanelImpossibleVolume() {
        List<int[]> testCase = new ArrayList<>();
        int[] pair1 = {2, 4};
        testCase.add(pair1);
        Assert.assertEquals(Arrays.deepToString(new Factory(testCase, 12).getResult().toArray()), "[]");
    }

    @Test
    // test on one panel with possible volume

    public void testOnOnePanelPossibleVolume() {
        List<int[]> testCase = new ArrayList<>();
        int[] pair1 = {2, 2};
        testCase.add(pair1);
        List<int[]> result = new ArrayList<>(3);
        result.add(pair1);
        result.add(pair1);
        result.add(pair1);
        Assert.assertEquals(Arrays.deepToString(new Factory(testCase, 8).getResult().toArray()), Arrays.deepToString(result.toArray()));
    }

    @Test
    // test on two panels with impossible volume

    public void testOnTwoPanelsImpossibleVolume() {
        List<int[]> testCase = new ArrayList<>();
        int[] pair1 = {2, 2};
        testCase.add(pair1);
        int[] pair2 = {2, 3};
        testCase.add(pair2);
        int[] pair3 = {2, 3};
        testCase.add(pair3);
        Assert.assertEquals(Arrays.deepToString(new Factory(testCase, 20).getResult().toArray()), "[]");
    }

    @Test
    // test on two panels with possible volume

    public void testOnTwoPanelsPossibleVolume() {
        List<int[]> testCase = new ArrayList<>();
        int[] pair1 = {2, 2};
        testCase.add(pair1);
        int[] pair2 = {2, 3};
        testCase.add(pair2);
        int[] pair3 = {2, 3};
        testCase.add(pair3);
        List<int[]> result = new ArrayList<>(3);
        result.add(pair1);
        result.add(pair2);
        result.add(pair3);
        Assert.assertEquals(Arrays.deepToString(new Factory(testCase, 12).getResult().toArray()), Arrays.deepToString(result.toArray()));
    }

    @Test
    // test on three panels with impossible volume

    public void testOnThreePanelsImpossibleVolume() {
        List<int[]> testCase = new ArrayList<>();
        int[] pair1 = {2, 3};
        testCase.add(pair1);
        int[] pair2 = {2, 4};
        testCase.add(pair2);
        int[] pair3 = {4, 3};
        testCase.add(pair3);
        Assert.assertEquals(Arrays.deepToString(new Factory(testCase, 12).getResult().toArray()), "[]");
    }

    @Test
    // test on three panels with possible volume

    public void testOnThreePanelsPossibleVolume() {
        List<int[]> testCase = new ArrayList<>();
        int[] pair1 = {2, 3};
        testCase.add(pair1);
        int[] pair2 = {2, 4};
        testCase.add(pair2);
        int[] pair3 = {4, 3};
        testCase.add(pair3);
        List<int[]> result = new ArrayList<>();
        result.add(pair1);
        result.add(pair2);
        result.add(pair3);
        Assert.assertEquals(Arrays.deepToString(new Factory(testCase, 24).getResult().toArray()), Arrays.deepToString(result.toArray()));
    }

    @Test
    // test on five duplicate panels with possible volume

    public void testOnFiveDuplicatePanelsPossibleVolume() {
        List<int[]> testCase = new ArrayList<>();
        int[] pair1 = {2, 3};
        testCase.add(pair1);
        int[] pair2 = {3, 2};
        testCase.add(pair1);
        int[] pair3 = {2, 2};
        testCase.add(pair1);
        testCase.add(pair2);
        testCase.add(pair3);
        List<int[]> result = new ArrayList<>();
        result.add(pair1);
        result.add(pair1);
        result.add(pair3);
        Assert.assertEquals(Arrays.deepToString(new Factory(testCase, 12).getResult().toArray()), Arrays.deepToString(result.toArray()));
    }

    @Test
    // test on five panels with possible volume of 24

    public void testOnFivePanelsPossibleVolume() {
        List<int[]> testCase = new ArrayList<>();
        int[] pair1 = {2, 3};
        testCase.add(pair1);
        int[] pair2 = {2, 4};
        testCase.add(pair2);
        int[] pair3 = {4, 3};
        testCase.add(pair3);
        int[] pair4 = {2, 5};
        testCase.add(pair4);
        int[] pair5 = {5, 3};
        testCase.add(pair5);
        List<int[]> result = new ArrayList<>();
        result.add(pair1);
        result.add(pair2);
        result.add(pair3);
        Assert.assertEquals(Arrays.deepToString(new Factory(testCase, 24).getResult().toArray()), Arrays.deepToString(result.toArray()));
    }

    @Test
    // test on five panels with possible volume of 30

    public void testOnFivePanelsPossibleVolume2() {
        List<int[]> testCase = new ArrayList<>();
        int[] pair1 = {2, 3};
        testCase.add(pair1);
        int[] pair2 = {2, 4};
        testCase.add(pair2);
        int[] pair3 = {4, 3};
        testCase.add(pair3);
        int[] pair4 = {2, 5};
        testCase.add(pair4);
        int[] pair5 = {5, 3};
        testCase.add(pair5);
        List<int[]> result = new ArrayList<>();
        result.add(pair1);
        result.add(pair4);
        result.add(pair5);
        Assert.assertEquals(Arrays.deepToString(new Factory(testCase, 30).getResult().toArray()), Arrays.deepToString(result.toArray()));
    }

    @Test
    // test with 2 valid triplets

    public void testTwoValidTriplets() {
        List<int[]> testCase = new ArrayList<>();
        int[] pair4 = {1, 27};
        testCase.add(pair4);
        int[] pair5 = {27, 30};
        testCase.add(pair5);
        int[] pair6 = {1, 30};
        testCase.add(pair6);
        int[] pair1 = {4, 9};
        testCase.add(pair1);
        int[] pair2 = {4, 15};
        testCase.add(pair2);
        int[] pair3 = {9, 15};
        testCase.add(pair3);
        List<int[]> result = new ArrayList<>();
        result.add(pair1);
        result.add(pair2);
        result.add(pair3);
        Assert.assertEquals(Arrays.deepToString(new Factory(testCase, 540).getResult().toArray()), Arrays.deepToString(result.toArray()));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    // test on five panels with invalid input data

    public void testOnInvalidPanelSize() {
        List<int[]> testCase = new ArrayList<>();
        int[] pair1 = {2, 3, 5};
        testCase.add(pair1);
        int[] pair2 = {2, 4};
        testCase.add(pair2);
        int[] pair3 = {4, 3};
        testCase.add(pair3);
        int[] pair4 = {2, 5};
        testCase.add(pair4);
        int[] pair5 = {5, 3};
        testCase.add(pair5);
        new Factory(testCase, 30).getResult();
    }
}