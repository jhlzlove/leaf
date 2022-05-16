import request from '@/utils/request'

// 查询供货商信息列表
export function listSupplier(query) {
  return request({
    url: '/system/supplier/list',
    method: 'get',
    params: query
  })
}

// 查询供货商信息详细
export function getSupplier(id) {
  return request({
    url: '/system/supplier/' + id,
    method: 'get'
  })
}

// 新增供货商信息
export function addSupplier(data) {
  return request({
    url: '/system/supplier',
    method: 'post',
    data: data
  })
}

// 修改供货商信息
export function updateSupplier(data) {
  return request({
    url: '/system/supplier',
    method: 'put',
    data: data
  })
}

// 删除供货商信息
export function delSupplier(id) {
  return request({
    url: '/system/supplier/' + id,
    method: 'delete'
  })
}
