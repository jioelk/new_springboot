package com.imooc.sell.Dao;

import com.imooc.sell.dataObject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @创建人 jioe
 * @创建时间 2019/3/3 19:33
 **/
public interface OrderDetailDao extends JpaRepository<OrderDetail,String> {
    List<OrderDetail> findByOrderId(String orderId);
}
