package com.daily.practice.dao.order;

import com.daily.practice.domain.d.o.OrderInfoDO;

public interface OrderInfoDAO {

    OrderInfoDO selectById(Long id);
}
