
/**
*获取导航树根节点
**/
function loadRoot(){
	var navigation =  [{id:"algorithm",text:"算法",hasChild:true}, {id:"stock",text:"股票",hasChild:true}];
	return navigation;
}


/**
* 根据父节点获取子节点
**/
function loadByParentid(id){
	var items;
	if(id == "algorithm"){
		items = [{id:"liangzhu",text:"量柱算法",hasChild:false}, {id:"paixu",text:"排序算法",hasChild:false}];
	}else if(id == "stock"){
		items = [{id:"huzhi",text:"沪指",hasChild:true}, {id:"shenzhi",text:"深指",hasChild:true}];
	}else if(id == "shenzhi"){
		items = [{id:"yhjt",text:"雅化集团",hasChild:false}, {id:"mhjt",text:"美好集团",hasChild:false}];
	}else if(id == "huzhi"){
		items = [{id:"zgzc",text:"中国中车",hasChild:false}, {id:"ywg",text:"远望谷",hasChild:false}];
	}
	return items;
}


/**
*获取grid数据
**/
function loadGridData(id){
	var data = [["高量柱","低量柱","高量柱数量","低量柱数量"],["1","2","4","5","8"],["2","2","4","5","8"],["3","2","4","5","8"],["4","2","4","5","8"],["5","2","4","5","8"]]
	return data;
}