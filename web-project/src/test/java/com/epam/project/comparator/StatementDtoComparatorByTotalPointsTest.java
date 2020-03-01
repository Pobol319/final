package com.epam.project.comparator;

import com.epam.project.entity.dto.StatementDto;
import org.junit.Assert;
import org.junit.Test;

public class StatementDtoComparatorByTotalPointsTest {

    @Test
    public void testCompareShouldReturnOne(){
        StatementDto statementDtoBigger = new StatementDto();
        statementDtoBigger.setTotalPoints(100);
        StatementDto statementDtoLower = new StatementDto();
        statementDtoLower.setTotalPoints(20);
        StatementDtoComparatorByTotalPoints comparator = new StatementDtoComparatorByTotalPoints();

        int result = comparator.compare(statementDtoBigger,statementDtoLower);
        Assert.assertEquals(1,result);
    }

    @Test
    public void testCompareShouldReturnMinusOne(){
        StatementDto statementDtoBigger = new StatementDto();
        statementDtoBigger.setTotalPoints(100);
        StatementDto statementDtoLower = new StatementDto();
        statementDtoLower.setTotalPoints(20);
        StatementDtoComparatorByTotalPoints comparator = new StatementDtoComparatorByTotalPoints();

        int result = comparator.compare(statementDtoLower,statementDtoBigger);
        Assert.assertEquals(-1,result);
    }

    @Test
    public void testCompareShouldReturnZero(){
        StatementDto statementDtoFirst = new StatementDto();
        statementDtoFirst.setTotalPoints(50);
        StatementDto statementDtoSecond = new StatementDto();
        statementDtoSecond.setTotalPoints(50);
        StatementDtoComparatorByTotalPoints comparator = new StatementDtoComparatorByTotalPoints();

        int result = comparator.compare(statementDtoSecond,statementDtoFirst);
        Assert.assertEquals(0,result);
    }
}
