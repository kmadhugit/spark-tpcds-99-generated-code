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
/* 021 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance7;
/* 022 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance8;
/* 023 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance9;
/* 024 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance10;
/* 025 */   private UnsafeRow scan_result;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 028 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 029 */   private UnsafeRow filter_result;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 032 */   private UnsafeRow project_result;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 035 */
/* 036 */   public GeneratedIterator(Object[] references) {
/* 037 */     this.references = references;
/* 038 */   }
/* 039 */
/* 040 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 041 */     partitionIndex = index;
/* 042 */     this.inputs = inputs;
/* 043 */     wholestagecodegen_init_0();
/* 044 */     wholestagecodegen_init_1();
/* 045 */
/* 046 */   }
/* 047 */
/* 048 */   private void wholestagecodegen_init_0() {
/* 049 */     scan_input = inputs[0];
/* 050 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 051 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 052 */     scan_scanTime1 = 0;
/* 053 */     scan_batch = null;
/* 054 */     scan_batchIdx = 0;
/* 055 */     scan_colInstance0 = null;
/* 056 */     scan_colInstance1 = null;
/* 057 */     scan_colInstance2 = null;
/* 058 */     scan_colInstance3 = null;
/* 059 */     scan_colInstance4 = null;
/* 060 */     scan_colInstance5 = null;
/* 061 */     scan_colInstance6 = null;
/* 062 */     scan_colInstance7 = null;
/* 063 */     scan_colInstance8 = null;
/* 064 */     scan_colInstance9 = null;
/* 065 */     scan_colInstance10 = null;
/* 066 */     scan_result = new UnsafeRow(11);
/* 067 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 288);
/* 068 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 11);
/* 069 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 070 */     filter_result = new UnsafeRow(11);
/* 071 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 288);
/* 072 */
/* 073 */   }
/* 074 */
/* 075 */   private void scan_nextBatch() throws java.io.IOException {
/* 076 */     long getBatchStart = System.nanoTime();
/* 077 */     if (scan_input.hasNext()) {
/* 078 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 079 */       scan_numOutputRows.add(scan_batch.numRows());
/* 080 */       scan_batchIdx = 0;
/* 081 */       scan_colInstance0 = scan_batch.column(0);
/* 082 */       scan_colInstance1 = scan_batch.column(1);
/* 083 */       scan_colInstance2 = scan_batch.column(2);
/* 084 */       scan_colInstance3 = scan_batch.column(3);
/* 085 */       scan_colInstance4 = scan_batch.column(4);
/* 086 */       scan_colInstance5 = scan_batch.column(5);
/* 087 */       scan_colInstance6 = scan_batch.column(6);
/* 088 */       scan_colInstance7 = scan_batch.column(7);
/* 089 */       scan_colInstance8 = scan_batch.column(8);
/* 090 */       scan_colInstance9 = scan_batch.column(9);
/* 091 */       scan_colInstance10 = scan_batch.column(10);
/* 092 */
/* 093 */     }
/* 094 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 095 */   }
/* 096 */
/* 097 */   private void wholestagecodegen_init_1() {
/* 098 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 11);
/* 099 */     project_result = new UnsafeRow(11);
/* 100 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 288);
/* 101 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 11);
/* 102 */
/* 103 */   }
/* 104 */
/* 105 */   protected void processNext() throws java.io.IOException {
/* 106 */     if (scan_batch == null) {
/* 107 */       scan_nextBatch();
/* 108 */     }
/* 109 */     while (scan_batch != null) {
/* 110 */       int scan_numRows = scan_batch.numRows();
/* 111 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 112 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 113 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 114 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 115 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 116 */
/* 117 */         if (!(!(scan_isNull))) continue;
/* 118 */
/* 119 */         filter_numOutputRows.add(1);
/* 120 */
/* 121 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 122 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 123 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 124 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 125 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 126 */         UTF8String scan_value3 = scan_isNull3 ? null : (scan_colInstance3.getUTF8String(scan_rowIdx));
/* 127 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 128 */         UTF8String scan_value4 = scan_isNull4 ? null : (scan_colInstance4.getUTF8String(scan_rowIdx));
/* 129 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 130 */         UTF8String scan_value5 = scan_isNull5 ? null : (scan_colInstance5.getUTF8String(scan_rowIdx));
/* 131 */         boolean scan_isNull6 = scan_colInstance6.isNullAt(scan_rowIdx);
/* 132 */         UTF8String scan_value6 = scan_isNull6 ? null : (scan_colInstance6.getUTF8String(scan_rowIdx));
/* 133 */         boolean scan_isNull7 = scan_colInstance7.isNullAt(scan_rowIdx);
/* 134 */         UTF8String scan_value7 = scan_isNull7 ? null : (scan_colInstance7.getUTF8String(scan_rowIdx));
/* 135 */         boolean scan_isNull8 = scan_colInstance8.isNullAt(scan_rowIdx);
/* 136 */         UTF8String scan_value8 = scan_isNull8 ? null : (scan_colInstance8.getUTF8String(scan_rowIdx));
/* 137 */         boolean scan_isNull9 = scan_colInstance9.isNullAt(scan_rowIdx);
/* 138 */         UTF8String scan_value9 = scan_isNull9 ? null : (scan_colInstance9.getUTF8String(scan_rowIdx));
/* 139 */         boolean scan_isNull10 = scan_colInstance10.isNullAt(scan_rowIdx);
/* 140 */         UTF8String scan_value10 = scan_isNull10 ? null : (scan_colInstance10.getUTF8String(scan_rowIdx));
/* 141 */         project_holder.reset();
/* 142 */
/* 143 */         project_rowWriter.zeroOutNullBytes();
/* 144 */
/* 145 */         project_rowWriter.write(0, scan_value);
/* 146 */
/* 147 */         if (scan_isNull1) {
/* 148 */           project_rowWriter.setNullAt(1);
/* 149 */         } else {
/* 150 */           project_rowWriter.write(1, scan_value1);
/* 151 */         }
/* 152 */
/* 153 */         if (scan_isNull2) {
/* 154 */           project_rowWriter.setNullAt(2);
/* 155 */         } else {
/* 156 */           project_rowWriter.write(2, scan_value2);
/* 157 */         }
/* 158 */
/* 159 */         if (scan_isNull3) {
/* 160 */           project_rowWriter.setNullAt(3);
/* 161 */         } else {
/* 162 */           project_rowWriter.write(3, scan_value3);
/* 163 */         }
/* 164 */
/* 165 */         if (scan_isNull4) {
/* 166 */           project_rowWriter.setNullAt(4);
/* 167 */         } else {
/* 168 */           project_rowWriter.write(4, scan_value4);
/* 169 */         }
/* 170 */
/* 171 */         if (scan_isNull5) {
/* 172 */           project_rowWriter.setNullAt(5);
/* 173 */         } else {
/* 174 */           project_rowWriter.write(5, scan_value5);
/* 175 */         }
/* 176 */
/* 177 */         if (scan_isNull6) {
/* 178 */           project_rowWriter.setNullAt(6);
/* 179 */         } else {
/* 180 */           project_rowWriter.write(6, scan_value6);
/* 181 */         }
/* 182 */
/* 183 */         if (scan_isNull7) {
/* 184 */           project_rowWriter.setNullAt(7);
/* 185 */         } else {
/* 186 */           project_rowWriter.write(7, scan_value7);
/* 187 */         }
/* 188 */
/* 189 */         if (scan_isNull8) {
/* 190 */           project_rowWriter.setNullAt(8);
/* 191 */         } else {
/* 192 */           project_rowWriter.write(8, scan_value8);
/* 193 */         }
/* 194 */
/* 195 */         if (scan_isNull9) {
/* 196 */           project_rowWriter.setNullAt(9);
/* 197 */         } else {
/* 198 */           project_rowWriter.write(9, scan_value9);
/* 199 */         }
/* 200 */
/* 201 */         if (scan_isNull10) {
/* 202 */           project_rowWriter.setNullAt(10);
/* 203 */         } else {
/* 204 */           project_rowWriter.write(10, scan_value10);
/* 205 */         }
/* 206 */         project_result.setTotalSize(project_holder.totalSize());
/* 207 */         append(project_result);
/* 208 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 209 */       }
/* 210 */       scan_batchIdx = scan_numRows;
/* 211 */       scan_batch = null;
/* 212 */       scan_nextBatch();
/* 213 */     }
/* 214 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 215 */     scan_scanTime1 = 0;
/* 216 */   }
/* 217 */ }
