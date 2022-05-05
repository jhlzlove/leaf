<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="员工编号" prop="employeeCode">
        <el-input
          v-model="queryParams.employeeCode"
          placeholder="请输入员工编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="员工名称" prop="employeeName">
        <el-input
          v-model="queryParams.employeeName"
          placeholder="请输入员工名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="员工部门" prop="employeeDept">
        <el-input
          v-model="queryParams.employeeDept"
          placeholder="请输入员工部门"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="联系电话" prop="employeePhone">
        <el-input
          v-model="queryParams.employeePhone"
          placeholder="请输入联系电话"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:info:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:info:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:info:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:info:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="infoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="id" />
      <el-table-column label="员工编号" align="center" prop="employeeCode" />
      <el-table-column label="员工名称" align="center" prop="employeeName" />
      <el-table-column label="员工性别" align="center" prop="employeeSex" />
      <el-table-column label="员工部门" align="center" prop="employeeDept" />
      <el-table-column label="住址" align="center" prop="employeeAddress" />
      <el-table-column label="联系电话" align="center" prop="employeePhone" />
      <el-table-column label="身份证号" align="center" prop="employeeCard" />
      <el-table-column label="照片地址" align="center" prop="employeePhoto" />
      <el-table-column label="所在省" align="center" prop="province" />
      <el-table-column label="所在市" align="center" prop="city" />
      <el-table-column label="乡镇/街道" align="center" prop="town" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:info:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:info:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改员工信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        
        <el-form-item label="员工名称" prop="employeeName">
          <el-input v-model="form.employeeName" placeholder="请输入员工名称" />
        </el-form-item>
        <el-form-item label="员工部门" prop="employeeDept">
          <el-input v-model="form.employeeDept" placeholder="请输入员工部门" />
        </el-form-item>
        <el-form-item label="住址" prop="employeeAddress">
          <el-input v-model="form.employeeAddress" placeholder="请输入住址" />
        </el-form-item>
        <el-form-item label="联系电话" prop="employeePhone">
          <el-input v-model="form.employeePhone" placeholder="请输入联系电话" />
        </el-form-item>
        <el-form-item label="身份证号" prop="employeeCard">
          <el-input v-model="form.employeeCard" placeholder="请输入身份证号" />
        </el-form-item>
        <el-form-item label="照片地址" prop="employeePhoto">
          <el-input v-model="form.employeePhoto" placeholder="请输入照片地址" />
        </el-form-item>
        <el-form-item label="所在省" prop="province">
          <el-input v-model="form.province" placeholder="请输入所在省" />
        </el-form-item>
        <el-form-item label="所在市" prop="city">
          <el-input v-model="form.city" placeholder="请输入所在市" />
        </el-form-item>
        <el-form-item label="乡镇/街道" prop="town">
          <el-input v-model="form.town" placeholder="请输入乡镇/街道" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listInfo, getInfo, delInfo, addInfo, updateInfo } from "@/api/system/employee";

export default {
  name: "Employee",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 员工信息表格数据
      infoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        employeeCode: null,
        employeeName: null,
        employeeDept: null,
        employeePhone: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        employeeName: [
          { required: true, message: "员工名称不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询员工信息列表 */
    getList() {
      this.loading = true;
      listInfo(this.queryParams).then(response => {
        this.infoList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        employeeCode: null,
        employeeName: null,
        employeeSex: null,
        employeeDept: null,
        employeeAddress: null,
        employeePhone: null,
        employeeCard: null,
        employeePhoto: null,
        province: null,
        city: null,
        town: null,
        delFlag: null,
        createBy: null,
        createTime: null,
        updateTime: null,
        updateBy: null,
        remark: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加员工信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getInfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改员工信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateInfo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addInfo(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除员工信息编号为"' + ids + '"的数据项？').then(function() {
        return delInfo(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/employee/export', {
        ...this.queryParams
      }, `employee_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
