package com.rbc.stocks.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.rbc.stocks.web.rest.TestUtil;

public class DowJonesIndexTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(DowJonesIndex.class);
        DowJonesIndex dowJonesIndex1 = new DowJonesIndex();
        dowJonesIndex1.setId(1L);
        DowJonesIndex dowJonesIndex2 = new DowJonesIndex();
        dowJonesIndex2.setId(dowJonesIndex1.getId());
        assertThat(dowJonesIndex1).isEqualTo(dowJonesIndex2);
        dowJonesIndex2.setId(2L);
        assertThat(dowJonesIndex1).isNotEqualTo(dowJonesIndex2);
        dowJonesIndex1.setId(null);
        assertThat(dowJonesIndex1).isNotEqualTo(dowJonesIndex2);
    }
}
