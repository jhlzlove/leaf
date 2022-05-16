<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="统一信用码" prop="supplierCode">
        <el-input
          v-model="queryParams.supplierCode"
          placeholder="统一信用码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="企业名称" prop="supplierName">
        <el-input
          v-model="queryParams.supplierName"
          placeholder="请输入供应商名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="联系人" prop="linkMan">
        <el-input
          v-model="queryParams.linkMan"
          placeholder="请输入联系人"
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
          v-hasPermi="['system:supplier:add']"
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
          v-hasPermi="['system:supplier:edit']"
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
          v-hasPermi="['system:supplier:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:supplier:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="supplierList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="id" />
      <el-table-column label="统一信用码" align="center" prop="supplierCode" />
      <el-table-column label="供应商名称" align="center" prop="supplierName" />
      <el-table-column label="地址" align="center" prop="supplierAddress" />
      <el-table-column label="联系人" align="center" prop="linkMan" />
      <el-table-column label="联系方式" align="center" prop="supplierMobile" />
      <el-table-column label="经营执照" align="center" prop="supplierLicenseFont" />
      <el-table-column label="经营执照" align="center" prop="supplierLicenseBack" />
      <el-table-column label="公司老板" align="center" prop="supplierLeader" />
      <el-table-column label="联系方式" align="center" prop="leaderPhone" />
      <el-table-column label="上市日期" align="center" prop="listingDate" />
      <el-table-column label="供应/合作状态" align="center" prop="status" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:supplier:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:supplier:remove']"
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

    <!-- 添加或修改供货商信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="统一信用码" prop="supplierCode">
          <el-input v-model="form.supplierCode" placeholder="请输入供应商社会统一信用码" />
        </el-form-item>
        <el-form-item label="供应商名称" prop="supplierName">
          <el-input v-model="form.supplierName" placeholder="请输入供应商名称" />
        </el-form-item>
        <el-form-item label="地址" prop="supplierAddress">
          <el-input v-model="form.supplierAddress" placeholder="请输入地址" />
        </el-form-item>
        <el-form-item label="联系人" prop="linkMan">
          <el-input v-model="form.linkMan" placeholder="请输入联系人" />
        </el-form-item>
        <el-form-item label="联系方式" prop="supplierMobile">
          <el-input v-model="form.supplierMobile" placeholder="请输入联系方式" />
        </el-form-item>
        <el-form-item label="经营执照" prop="supplierLicenseFont">
          <el-input v-model="form.supplierLicenseFont" placeholder="请输入经营执照" />
        </el-form-item>
        <el-form-item label="经营执照" prop="supplierLicenseBack">
          <el-input v-model="form.supplierLicenseBack" placeholder="请输入经营执照" />
        </el-form-item>
        <el-form-item label="公司老板" prop="supplierLeader">
          <el-input v-model="form.supplierLeader" placeholder="请输入公司老板" />
        </el-form-item>
        <el-form-item label="联系方式" prop="leaderPhone">
          <el-input v-model="form.leaderPhone" placeholder="请输入联系方式" />
        </el-form-item>
        <el-form-item label="上市日期" prop="listingDate">
          <el-input v-model="form.listingDate" placeholder="请输入上市日期" />
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
import { listSupplier, getSupplier, delSupplier, addSupplier, updateSupplier } from "@/api/system/supplier";

export default {
  name: "Supplier",
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
      // 供货商信息表格数据
      supplierList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        supplierCode: null,
        supplierName: null,
        supplierAddress: null,
        linkMan: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        supplierName: [
          { required: true, message: "供应商名称不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询供货商信息列表 */
    getList() {
      this.loading = true;
      listSupplier(this.queryParams).then(response => {
        this.supplierList = response.rows;
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
        supplierCode: null,
        supplierName: null,
        supplierAddress: null,
        linkMan: null,
        supplierMobile: null,
        supplierLicenseFont: null,
        supplierLicenseBack: null,
        supplierLeader: null,
        leaderPhone: null,
        listingDate: null,
        delFlag: null,
        status: "0",
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
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
      this.title = "添加供货商信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getSupplier(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改供货商信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateSupplier(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSupplier(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除供货商信息编号为"' + ids + '"的数据项？').then(function() {
        return delSupplier(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/supplier/export', {
        ...this.queryParams
      }, `supplier_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
