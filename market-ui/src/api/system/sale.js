import request from '@/utils/request'

// 查询商品销售列表
export function listSale(query) {
  return request({
    url: '/system/sale/list',
    method: 'get',
    params: query
  })
}

// 查询商品销售详细
export function getSale(id) {
  return request({
    url: '/system/sale/' + id,
    method: 'get'
  })
}

// 新增商品销售
export function addSale(data) {
  return request({
    url: '/system/sale',
    method: 'post',
    data: data
  })
}

// 修改商品销售
export function updateSale(data) {
  return request({
    url: '/system/sale',
    method: 'put',
    data: data
  })
}

// 删除商品销售
export function delSale(id) {
  return request({
    url: '/system/sale/' + id,
    method: 'delete'
  })
}
