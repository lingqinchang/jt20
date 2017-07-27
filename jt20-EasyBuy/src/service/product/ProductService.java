package service.product;

import util.Page;
import util.ResultData;

public interface ProductService {
      //根据级别查询商品
	  public ResultData getCategoryByType(Integer type);
	  //查询所有的商品类别
	  public ResultData getCategorysByPage(Page page);
	  //获取商品类别总记录数
	  public int getCategoryCount();
	  //获取指定级别是商品类别
	  public ResultData getCategoryByType2(Integer type);
	  //获取指定级别的商品类别
	  public ResultData getCategoryByParentId(Integer parentId);
}
