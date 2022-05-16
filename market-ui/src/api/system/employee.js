import request from '@/utils/request'

// 查询员工信息列表
export function listInfo(query) {
  return request({
    url: '/system/employee/list',
    method: 'get',
    params: query
  })
}

// 查询员工信息详细
export function getInfo(id) {
  return request({
    url: '/system/employee/' + id,
    method: 'get'
  })
}

// 新增员工信息
export function addInfo(data) {
  return request({
    url: '/system/employee',
    method: 'post',
    data: data
  })
}

// 修改员工信息
export function updateInfo(data) {
  return request({
    url: '/system/employee',
    method: 'put',
    data: data
  })
}

// 删除员工信息
export function delInfo(id) {
  return request({
    url: '/system/employee/' + id,
    method: 'delete'
  })
}
