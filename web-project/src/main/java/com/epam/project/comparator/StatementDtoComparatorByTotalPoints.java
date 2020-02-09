package com.epam.project.comparator;

import com.epam.project.entity.dto.StatementDto;

import java.util.Comparator;

public class StatementDtoComparatorByTotalPoints implements Comparator<StatementDto> {

    @Override
    public int compare(StatementDto o1, StatementDto o2) {
        return Integer.compare(o1.getTotalPoints(), o2.getTotalPoints());
    }

}
