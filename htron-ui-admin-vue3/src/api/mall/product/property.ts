import request from '@/config/axios'

/**
 * 商品属性
 */
export interface PropertyVO {
  id?: number
  /** 名称 */
  name: string
  /** 备注 */
  remark?: string
}

/**
 * 属性值
 */
export interface PropertyValueVO {
  id?: number
  /** 属性项的编号 */
  propertyId?: number
  /** 名称 */
  name: string
  /** 备注 */
  remark?: string
}

/**
 * 商品属性值的明细
 */
export interface PropertyValueDetailVO {
  /** 属性项的编号 */
  propertyId: number // 属性的编号
  /** 属性的名称 */
  propertyName: string
  /** 属性值的编号 */
  valueId: number
  /** 属性值的名称 */
  valueName: string
}

// ------------------------ 属性项 -------------------

// 创建属性项
export const createProperty = (data: PropertyVO) => {
  return request.post({ url: '/product/property/create', data })
}

// 更新属性项
export const updateProperty = (data: PropertyVO) => {
  return request.put({ url: '/product/property/update', data })
}

// 删除属性项
export const deleteProperty = (id: number) => {
  return request.delete({ url: `/product/property/delete?id=${id}` })
}

// 获得属性项
export const getProperty = (id: number): Promise<PropertyVO> => {
  return request.get({ url: `/product/property/get?id=${id}` })
}

// 获得属性项分页
export const getPropertyPage = (params: PageParam) => {
  return request.get({ url: '/product/property/page', params })
}

// 获得属性项列表
export const getPropertyList = (params: any) => {
  return request.get({ url: '/product/property/list', params })
}

// 获得属性项列表
export const getPropertyListAndValue = (data: any) => {
  return request.post({ url: '/product/property/get-value-list', data })
}

// ------------------------ 属性值 -------------------

// 获得属性值分页
export const getPropertyValuePage = (params: PageParam & any) => {
  return request.get({ url: '/product/property/value/page', params })
}

// 获得属性值
export const getPropertyValue = (id: number): Promise<PropertyValueVO> => {
  return request.get({ url: `/product/property/value/get?id=${id}` })
}

// 创建属性值
export const createPropertyValue = (data: PropertyValueVO) => {
  return request.post({ url: '/product/property/value/create', data })
}

// 更新属性值
export const updatePropertyValue = (data: PropertyValueVO) => {
  return request.put({ url: '/product/property/value/update', data })
}

// 删除属性值
export const deletePropertyValue = (id: number) => {
  return request.delete({ url: `/product/property/value/delete?id=${id}` })
}
