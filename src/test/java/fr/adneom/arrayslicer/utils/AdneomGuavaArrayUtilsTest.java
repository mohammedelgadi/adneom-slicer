package fr.adneom.arrayslicer.utils;

import fr.adneom.arrayslicer.utils.impl.AdneomGuavaArrayUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdneomGuavaArrayUtilsTest {

	@Autowired
    AdneomGuavaArrayUtils adneomGuavaArrayUtils;


	/**
	 * Test nominal 01
	 * Description : partition([1,2,3,4,5], 2) return: [ [1,2], [3,4], [5] ]
	 */
	@Test
	public void testPartitionArray_nominalTest01() {
        // prepare
        List<Integer> input = Arrays.asList(1,2,3,4,5);
        // run
        List<List<Integer>> output = adneomGuavaArrayUtils.partition(input, 2);
        // verify
        assertThat(output, is(notNullValue()));
        assertThat(output.size(), is(3));
        assertThat(output.get(0).size(), is(2));
        assertThat(output.get(0), CoreMatchers.hasItems(1, 2));
        assertThat(output.get(1).size(), is(2));
        assertThat(output.get(1), CoreMatchers.hasItems(3, 4));
        assertThat(output.get(2).size(), is(1));
        assertThat(output.get(2), CoreMatchers.hasItems(5));
	}

	/**
	 * Test nominal 02
	 * Description : partition([1,2,3,4,5], 3) return: [ [1,2,3], [4,5] ]
	 */
    @Test
    public void testPartitionArray_nominalTest02() {
        // prepare
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        // run
        List<List<Integer>> output = adneomGuavaArrayUtils.partition(input, 3);
        // verify
        assertThat(output, is(notNullValue()));
        assertThat(output.size(), is(2));
        assertThat(output.get(0).size(), is(3));
        assertThat(output.get(0), CoreMatchers.hasItems(1, 2, 3));
        assertThat(output.get(1).size(), is(2));
        assertThat(output.get(1), CoreMatchers.hasItems(4, 5));

    }

	/**
	 * Test nominal 03
	 * Description : partition([1,2,3,4,5], 1) return: [ [1], [2], [3], [4], [5] ]
	 */
	@Test
	public void testPartitionArray_nominalTest03() {
        // prepare
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        // run
        List<List<Integer>> output = adneomGuavaArrayUtils.partition(input, 1);
        // verify
        assertThat(output, is(notNullValue()));
        assertThat(output.size(), is(5));
        output.forEach(s -> assertThat(s.size(), is(1)));
        assertThat(output.get(0), CoreMatchers.hasItems(1));
        assertThat(output.get(1), CoreMatchers.hasItems(2));
        assertThat(output.get(2), CoreMatchers.hasItems(3));
        assertThat(output.get(3), CoreMatchers.hasItems(4));
        assertThat(output.get(4), CoreMatchers.hasItems(5));
    }

    @Test
    public void testPartitionArray_shouldReturnNull_whenInputListIsEmpty() {
        // prepare
        List<Integer> input = null;
        // run
        List<List<Integer>> output = adneomGuavaArrayUtils.partition(input, 2);
        // verify
        assertThat(output, is(empty()));
    }

    @Test
    public void testPartitionArray_shouldReturnOneChild_whenInputSizeHigherThanListSize() {
        // prepare
        List<Integer> input = Arrays.asList(1, 2, 4);
        // run
        List<List<Integer>> output = adneomGuavaArrayUtils.partition(input, 10);
        // verify
        assertThat(output, is(notNullValue()));
        assertThat(output.size(), is(1));
    }



}
