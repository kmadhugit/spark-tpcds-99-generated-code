/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator scan_input;
/* 009 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 010 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 011 */   private long scan_scanTime1;
/* 012 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 013 */   private int scan_batchIdx;
/* 014 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 015 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 016 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 017 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 018 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 019 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance5;
/* 020 */   private UnsafeRow scan_result;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 023 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 024 */   private UnsafeRow filter_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 027 */   private UnsafeRow project_result;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 030 */
/* 031 */   public GeneratedIterator(Object[] references) {
/* 032 */     this.references = references;
/* 033 */   }
/* 034 */
/* 035 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 036 */     partitionIndex = index;
/* 037 */     this.inputs = inputs;
/* 038 */     wholestagecodegen_init_0();
/* 039 */     wholestagecodegen_init_1();
/* 040 */
/* 041 */   }
/* 042 */
/* 043 */   private void wholestagecodegen_init_0() {
/* 044 */     scan_input = inputs[0];
/* 045 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 046 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 047 */     scan_scanTime1 = 0;
/* 048 */     scan_batch = null;
/* 049 */     scan_batchIdx = 0;
/* 050 */     scan_colInstance0 = null;
/* 051 */     scan_colInstance1 = null;
/* 052 */     scan_colInstance2 = null;
/* 053 */     scan_colInstance3 = null;
/* 054 */     scan_colInstance4 = null;
/* 055 */     scan_colInstance5 = null;
/* 056 */     scan_result = new UnsafeRow(6);
/* 057 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 058 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 6);
/* 059 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 060 */     filter_result = new UnsafeRow(6);
/* 061 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 062 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 6);
/* 063 */     project_result = new UnsafeRow(6);
/* 064 */
/* 065 */   }
/* 066 */
/* 067 */   private void scan_nextBatch() throws java.io.IOException {
/* 068 */     long getBatchStart = System.nanoTime();
/* 069 */     if (scan_input.hasNext()) {
/* 070 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 071 */       scan_numOutputRows.add(scan_batch.numRows());
/* 072 */       scan_batchIdx = 0;
/* 073 */       scan_colInstance0 = scan_batch.column(0);
/* 074 */       scan_colInstance1 = scan_batch.column(1);
/* 075 */       scan_colInstance2 = scan_batch.column(2);
/* 076 */       scan_colInstance3 = scan_batch.column(3);
/* 077 */       scan_colInstance4 = scan_batch.column(4);
/* 078 */       scan_colInstance5 = scan_batch.column(5);
/* 079 */
/* 080 */     }
/* 081 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 082 */   }
/* 083 */
/* 084 */   private void wholestagecodegen_init_1() {
/* 085 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 086 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 6);
/* 087 */
/* 088 */   }
/* 089 */
/* 090 */   protected void processNext() throws java.io.IOException {
/* 091 */     if (scan_batch == null) {
/* 092 */       scan_nextBatch();
/* 093 */     }
/* 094 */     while (scan_batch != null) {
/* 095 */       int scan_numRows = scan_batch.numRows();
/* 096 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 097 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 098 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 099 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 100 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 101 */
/* 102 */         if (!(!(scan_isNull))) continue;
/* 103 */
/* 104 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 105 */         int scan_value5 = scan_isNull5 ? -1 : (scan_colInstance5.getInt(scan_rowIdx));
/* 106 */
/* 107 */         if (!(!(scan_isNull5))) continue;
/* 108 */
/* 109 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 110 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 111 */
/* 112 */         if (!(!(scan_isNull4))) continue;
/* 113 */
/* 114 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 115 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 116 */
/* 117 */         if (!(!(scan_isNull1))) continue;
/* 118 */
/* 119 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 120 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 121 */
/* 122 */         if (!(!(scan_isNull2))) continue;
/* 123 */
/* 124 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 125 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 126 */
/* 127 */         if (!(!(scan_isNull3))) continue;
/* 128 */
/* 129 */         filter_numOutputRows.add(1);
/* 130 */
/* 131 */         project_rowWriter.write(0, scan_value);
/* 132 */
/* 133 */         project_rowWriter.write(1, scan_value1);
/* 134 */
/* 135 */         project_rowWriter.write(2, scan_value2);
/* 136 */
/* 137 */         project_rowWriter.write(3, scan_value3);
/* 138 */
/* 139 */         project_rowWriter.write(4, scan_value4);
/* 140 */
/* 141 */         project_rowWriter.write(5, scan_value5);
/* 142 */         append(project_result);
/* 143 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 144 */       }
/* 145 */       scan_batchIdx = scan_numRows;
/* 146 */       scan_batch = null;
/* 147 */       scan_nextBatch();
/* 148 */     }
/* 149 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 150 */     scan_scanTime1 = 0;
/* 151 */   }
/* 152 */ }
