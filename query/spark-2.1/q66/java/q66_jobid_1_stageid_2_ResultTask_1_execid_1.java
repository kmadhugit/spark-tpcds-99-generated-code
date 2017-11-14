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
/* 020 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance6;
/* 021 */   private UnsafeRow scan_result;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 024 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 025 */   private UnsafeRow filter_result;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 028 */   private UnsafeRow project_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 031 */
/* 032 */   public GeneratedIterator(Object[] references) {
/* 033 */     this.references = references;
/* 034 */   }
/* 035 */
/* 036 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 037 */     partitionIndex = index;
/* 038 */     this.inputs = inputs;
/* 039 */     wholestagecodegen_init_0();
/* 040 */     wholestagecodegen_init_1();
/* 041 */
/* 042 */   }
/* 043 */
/* 044 */   private void wholestagecodegen_init_0() {
/* 045 */     scan_input = inputs[0];
/* 046 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 047 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 048 */     scan_scanTime1 = 0;
/* 049 */     scan_batch = null;
/* 050 */     scan_batchIdx = 0;
/* 051 */     scan_colInstance0 = null;
/* 052 */     scan_colInstance1 = null;
/* 053 */     scan_colInstance2 = null;
/* 054 */     scan_colInstance3 = null;
/* 055 */     scan_colInstance4 = null;
/* 056 */     scan_colInstance5 = null;
/* 057 */     scan_colInstance6 = null;
/* 058 */     scan_result = new UnsafeRow(7);
/* 059 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 160);
/* 060 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 7);
/* 061 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 062 */     filter_result = new UnsafeRow(7);
/* 063 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 160);
/* 064 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 7);
/* 065 */
/* 066 */   }
/* 067 */
/* 068 */   private void scan_nextBatch() throws java.io.IOException {
/* 069 */     long getBatchStart = System.nanoTime();
/* 070 */     if (scan_input.hasNext()) {
/* 071 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 072 */       scan_numOutputRows.add(scan_batch.numRows());
/* 073 */       scan_batchIdx = 0;
/* 074 */       scan_colInstance0 = scan_batch.column(0);
/* 075 */       scan_colInstance1 = scan_batch.column(1);
/* 076 */       scan_colInstance2 = scan_batch.column(2);
/* 077 */       scan_colInstance3 = scan_batch.column(3);
/* 078 */       scan_colInstance4 = scan_batch.column(4);
/* 079 */       scan_colInstance5 = scan_batch.column(5);
/* 080 */       scan_colInstance6 = scan_batch.column(6);
/* 081 */
/* 082 */     }
/* 083 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 084 */   }
/* 085 */
/* 086 */   private void wholestagecodegen_init_1() {
/* 087 */     project_result = new UnsafeRow(7);
/* 088 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 160);
/* 089 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 7);
/* 090 */
/* 091 */   }
/* 092 */
/* 093 */   protected void processNext() throws java.io.IOException {
/* 094 */     if (scan_batch == null) {
/* 095 */       scan_nextBatch();
/* 096 */     }
/* 097 */     while (scan_batch != null) {
/* 098 */       int numRows = scan_batch.numRows();
/* 099 */       while (scan_batchIdx < numRows) {
/* 100 */         int scan_rowIdx = scan_batchIdx++;
/* 101 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 102 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 103 */
/* 104 */         if (!(!(scan_isNull))) continue;
/* 105 */
/* 106 */         filter_numOutputRows.add(1);
/* 107 */
/* 108 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 109 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 110 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 111 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 112 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 113 */         UTF8String scan_value3 = scan_isNull3 ? null : (scan_colInstance3.getUTF8String(scan_rowIdx));
/* 114 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 115 */         UTF8String scan_value4 = scan_isNull4 ? null : (scan_colInstance4.getUTF8String(scan_rowIdx));
/* 116 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 117 */         UTF8String scan_value5 = scan_isNull5 ? null : (scan_colInstance5.getUTF8String(scan_rowIdx));
/* 118 */         boolean scan_isNull6 = scan_colInstance6.isNullAt(scan_rowIdx);
/* 119 */         UTF8String scan_value6 = scan_isNull6 ? null : (scan_colInstance6.getUTF8String(scan_rowIdx));
/* 120 */         project_holder.reset();
/* 121 */
/* 122 */         project_rowWriter.zeroOutNullBytes();
/* 123 */
/* 124 */         project_rowWriter.write(0, scan_value);
/* 125 */
/* 126 */         if (scan_isNull1) {
/* 127 */           project_rowWriter.setNullAt(1);
/* 128 */         } else {
/* 129 */           project_rowWriter.write(1, scan_value1);
/* 130 */         }
/* 131 */
/* 132 */         if (scan_isNull2) {
/* 133 */           project_rowWriter.setNullAt(2);
/* 134 */         } else {
/* 135 */           project_rowWriter.write(2, scan_value2);
/* 136 */         }
/* 137 */
/* 138 */         if (scan_isNull3) {
/* 139 */           project_rowWriter.setNullAt(3);
/* 140 */         } else {
/* 141 */           project_rowWriter.write(3, scan_value3);
/* 142 */         }
/* 143 */
/* 144 */         if (scan_isNull4) {
/* 145 */           project_rowWriter.setNullAt(4);
/* 146 */         } else {
/* 147 */           project_rowWriter.write(4, scan_value4);
/* 148 */         }
/* 149 */
/* 150 */         if (scan_isNull5) {
/* 151 */           project_rowWriter.setNullAt(5);
/* 152 */         } else {
/* 153 */           project_rowWriter.write(5, scan_value5);
/* 154 */         }
/* 155 */
/* 156 */         if (scan_isNull6) {
/* 157 */           project_rowWriter.setNullAt(6);
/* 158 */         } else {
/* 159 */           project_rowWriter.write(6, scan_value6);
/* 160 */         }
/* 161 */         project_result.setTotalSize(project_holder.totalSize());
/* 162 */         append(project_result);
/* 163 */         if (shouldStop()) return;
/* 164 */       }
/* 165 */       scan_batch = null;
/* 166 */       scan_nextBatch();
/* 167 */     }
/* 168 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 169 */     scan_scanTime1 = 0;
/* 170 */   }
/* 171 */ }
