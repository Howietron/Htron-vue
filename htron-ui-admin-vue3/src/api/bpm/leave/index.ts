import request from '@/config/axios'

export type LeaveVO = {
  id: number
  result: number
  type: number
  reason: string
  processInstanceId: string
  startTime: string
  endTime: string
  createTime: string
}

// 创建请假申请
export const createLeave = async (data: LeaveVO) => {
  return await request.post({ url: '/bpm/oa/leave/create', data: data })
}

// 获得请假申请
export const getLeave = async (id: number) => {
  return await request.get({ url: '/bpm/oa/leave/get?id=' + id })
}

// 获得请假申请分页
export const getLeavePage = async (params: PageParam) => {
  return await request.get({ url: '/bpm/oa/leave/page', params })
}
