<template>
  <div class="app-container">
    <!-- 
      模糊搜索
     -->
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="商品编码" prop="goodsCode">
        <el-input
          v-model="queryParams.goodsCode"
          placeholder="请输入商品编码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品名称" prop="goodsName">
        <el-input
          v-model="queryParams.goodsName"
          placeholder="请输入商品名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="保质期" prop="saveDate">
        <el-input
          v-model="queryParams.saveDate"
          placeholder="请输入保质期"
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
      <el-table-column label="商品编码" align="center" prop="goodsCode" />
      <el-table-column label="商品名称" align="center" prop="goodsName" />
      <el-table-column label="商品类型" align="center" prop="goodsType" />
      <el-table-column label="商品供货商编码" align="center" prop="goodsSupplier" />
      <el-table-column label="商品数量" align="center" prop="goodsNumber" />
      <el-table-column label="商品定价" align="center" prop="goodsPrice" />
      <el-table-column label="折扣" align="center" prop="goodsDiscount" />
      <el-table-column label="优惠价格" align="center" prop="goodsPreferential" />
      <el-table-column label="生产日期" align="center" prop="manufacturingDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.manufacturingDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="保质期" align="center" prop="saveDate" />
      <el-table-column label="计量方式" align="center" prop="meteringWay" />
      <el-table-column label="供应状态" align="center" prop="status" >
        <template slot-scope="scope">
            {{scope.row.type === 0 ? "正常" : "下架"}}
        </template>
      </el-table-column>
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

    <!-- 添加或修改商品信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="商品名称" prop="goodsName">
          <el-input v-model="form.goodsName" placeholder="请输入商品名称" />
        </el-form-item>
        <el-form-item label="商品类型" prop="goodsType">
          <el-input v-model="form.goodsType" placeholder="请输入商品类型" />
        </el-form-item>
        <el-form-item label="商品供货商编码" prop="goodsSupplier">
          <el-input v-model="form.goodsSupplier" placeholder="请输入商品供货商编码" />
        </el-form-item>
        <el-form-item label="商品数量" prop="goodsNumber">
          <el-input v-model="form.goodsNumber" placeholder="请输入商品数量" />
        </el-form-item>
        <el-form-item label="商品定价" prop="goodsPrice">
          <el-input v-model="form.goodsPrice" placeholder="请输入商品定价" />
        </el-form-item>
        <el-form-item label="折扣" prop="goodsDiscount">
          <el-input v-model="form.goodsDiscount" placeholder="请输入折扣" />
        </el-form-item>
        <el-form-item label="优惠价格" prop="goodsPreferential">
          <el-input v-model="form.goodsPreferential" placeholder="请输入优惠价格" />
        </el-form-item>
        <el-form-item label="生产日期" prop="manufacturingDate">
          <el-date-picker clearable size="small"
            v-model="form.manufacturingDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择生产日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="保质期" prop="saveDate">
          <el-input v-model="form.saveDate" placeholder="请输入保质期"/>
        </el-form-item>
        <el-form-item label="计量方式" prop="meteringWay">
          <el-input v-model="form.meteringWay" placeholder="请输入计量方式" />
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
import { listInfo, getInfo, delInfo, addInfo, updateInfo, typeListInfo } from "@/api/system/goods";

export default {
  name: "Goods",
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
      // 商品信息表格数据
      infoList: [],
      typeList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        goodsCode: null,
        goodsName: null,
        goodsCategoy: null,
        goodsType: null,
        goodsSupplier: null,
        goodsNumber: null,
        goodsPrice: null,
        goodsDiscount: null,
        goodsPreferential: null,
        manufacturingDate: null,
        saveDate: null,
        meteringWay: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        goodsCode: [
          { required: true, message: "商品编码不能为空", trigger: "blur" }
        ],
        goodsName: [
          { required: true, message: "商品名称不能为空", trigger: "blur" }
        ],
        goodsCategoy: [
          { required: true, message: "商品分类不能为空", trigger: "change" }
        ],
        goodsType: [
          { required: true, message: "商品类型不能为空", trigger: "change" }
        ],
        goodsSupplier: [
          { required: true, message: "商品供货商编码不能为空", trigger: "blur" }
        ],
        goodsNumber: [
          { required: true, message: "商品数量不能为空", trigger: "blur" }
        ],
        goodsPrice: [
          { required: true, message: "商品定价不能为空", trigger: "blur" }
        ],
        createTime: [
          { required: true, message: "信息创建时间不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
    this.getTypeList();
  },
  methods: {
    /** 查询商品信息列表 */
    getList() {
      this.loading = true;
      listInfo(this.queryParams).then(response => {
        this.infoList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    getTypeList() {
      this.loading = true;
      typeListInfo(this.queryParams).then(response => {
        this.typeList = response.rows;
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
        goodsCode: null,
        goodsName: null,
        goodsCategoy: null,
        goodsType: null,
        goodsSupplier: null,
        goodsNumber: null,
        goodsPrice: null,
        goodsDiscount: null,
        goodsPreferential: null,
        manufacturingDate: null,
        saveDate: null,
        meteringWay: null,
        status: 0,
        delFlag: null,
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
      this.title = "添加商品信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getInfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改商品信息";
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
      this.$modal.confirm('是否确认删除商品信息编号为"' + ids + '"的数据项？').then(function() {
        return delInfo(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/goods/export', {
        ...this.queryParams
      }, `goodsinfo_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
