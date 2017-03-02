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
/* 025 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance11;
/* 026 */   private UnsafeRow scan_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 030 */   private UnsafeRow filter_result;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 033 */   private UnsafeRow project_result;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 036 */
/* 037 */   public GeneratedIterator(Object[] references) {
/* 038 */     this.references = references;
/* 039 */   }
/* 040 */
/* 041 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 042 */     partitionIndex = index;
/* 043 */     this.inputs = inputs;
/* 044 */     wholestagecodegen_init_0();
/* 045 */     wholestagecodegen_init_1();
/* 046 */
/* 047 */   }
/* 048 */
/* 049 */   private void wholestagecodegen_init_0() {
/* 050 */     scan_input = inputs[0];
/* 051 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 052 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 053 */     scan_scanTime1 = 0;
/* 054 */     scan_batch = null;
/* 055 */     scan_batchIdx = 0;
/* 056 */     scan_colInstance0 = null;
/* 057 */     scan_colInstance1 = null;
/* 058 */     scan_colInstance2 = null;
/* 059 */     scan_colInstance3 = null;
/* 060 */     scan_colInstance4 = null;
/* 061 */     scan_colInstance5 = null;
/* 062 */     scan_colInstance6 = null;
/* 063 */     scan_colInstance7 = null;
/* 064 */     scan_colInstance8 = null;
/* 065 */     scan_colInstance9 = null;
/* 066 */     scan_colInstance10 = null;
/* 067 */     scan_colInstance11 = null;
/* 068 */     scan_result = new UnsafeRow(12);
/* 069 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 320);
/* 070 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 12);
/* 071 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 072 */     filter_result = new UnsafeRow(12);
/* 073 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 320);
/* 074 */
/* 075 */   }
/* 076 */
/* 077 */   private void scan_nextBatch() throws java.io.IOException {
/* 078 */     long getBatchStart = System.nanoTime();
/* 079 */     if (scan_input.hasNext()) {
/* 080 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 081 */       scan_numOutputRows.add(scan_batch.numRows());
/* 082 */       scan_batchIdx = 0;
/* 083 */       scan_colInstance0 = scan_batch.column(0);
/* 084 */       scan_colInstance1 = scan_batch.column(1);
/* 085 */       scan_colInstance2 = scan_batch.column(2);
/* 086 */       scan_colInstance3 = scan_batch.column(3);
/* 087 */       scan_colInstance4 = scan_batch.column(4);
/* 088 */       scan_colInstance5 = scan_batch.column(5);
/* 089 */       scan_colInstance6 = scan_batch.column(6);
/* 090 */       scan_colInstance7 = scan_batch.column(7);
/* 091 */       scan_colInstance8 = scan_batch.column(8);
/* 092 */       scan_colInstance9 = scan_batch.column(9);
/* 093 */       scan_colInstance10 = scan_batch.column(10);
/* 094 */       scan_colInstance11 = scan_batch.column(11);
/* 095 */
/* 096 */     }
/* 097 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 098 */   }
/* 099 */
/* 100 */   private void wholestagecodegen_init_1() {
/* 101 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 12);
/* 102 */     project_result = new UnsafeRow(12);
/* 103 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 320);
/* 104 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 12);
/* 105 */
/* 106 */   }
/* 107 */
/* 108 */   protected void processNext() throws java.io.IOException {
/* 109 */     if (scan_batch == null) {
/* 110 */       scan_nextBatch();
/* 111 */     }
/* 112 */     while (scan_batch != null) {
/* 113 */       int numRows = scan_batch.numRows();
/* 114 */       while (scan_batchIdx < numRows) {
/* 115 */         int scan_rowIdx = scan_batchIdx++;
/* 116 */         boolean scan_isNull7 = scan_colInstance7.isNullAt(scan_rowIdx);
/* 117 */         UTF8String scan_value7 = scan_isNull7 ? null : (scan_colInstance7.getUTF8String(scan_rowIdx));
/* 118 */
/* 119 */         if (!(!(scan_isNull7))) continue;
/* 120 */
/* 121 */         boolean filter_isNull2 = false;
/* 122 */
/* 123 */         Object filter_obj = ((Expression) references[3]).eval(null);
/* 124 */         UTF8String filter_value4 = (UTF8String) filter_obj;
/* 125 */         boolean filter_value2 = false;
/* 126 */         filter_value2 = scan_value7.equals(filter_value4);
/* 127 */         if (!filter_value2) continue;
/* 128 */
/* 129 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 130 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 131 */
/* 132 */         if (!(!(scan_isNull))) continue;
/* 133 */
/* 134 */         filter_numOutputRows.add(1);
/* 135 */
/* 136 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 137 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 138 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 139 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 140 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 141 */         UTF8String scan_value3 = scan_isNull3 ? null : (scan_colInstance3.getUTF8String(scan_rowIdx));
/* 142 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 143 */         UTF8String scan_value4 = scan_isNull4 ? null : (scan_colInstance4.getUTF8String(scan_rowIdx));
/* 144 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 145 */         UTF8String scan_value5 = scan_isNull5 ? null : (scan_colInstance5.getUTF8String(scan_rowIdx));
/* 146 */         boolean scan_isNull6 = scan_colInstance6.isNullAt(scan_rowIdx);
/* 147 */         UTF8String scan_value6 = scan_isNull6 ? null : (scan_colInstance6.getUTF8String(scan_rowIdx));
/* 148 */         boolean scan_isNull8 = scan_colInstance8.isNullAt(scan_rowIdx);
/* 149 */         UTF8String scan_value8 = scan_isNull8 ? null : (scan_colInstance8.getUTF8String(scan_rowIdx));
/* 150 */         boolean scan_isNull9 = scan_colInstance9.isNullAt(scan_rowIdx);
/* 151 */         UTF8String scan_value9 = scan_isNull9 ? null : (scan_colInstance9.getUTF8String(scan_rowIdx));
/* 152 */         boolean scan_isNull10 = scan_colInstance10.isNullAt(scan_rowIdx);
/* 153 */         double scan_value10 = scan_isNull10 ? -1.0 : (scan_colInstance10.getDouble(scan_rowIdx));
/* 154 */         boolean scan_isNull11 = scan_colInstance11.isNullAt(scan_rowIdx);
/* 155 */         UTF8String scan_value11 = scan_isNull11 ? null : (scan_colInstance11.getUTF8String(scan_rowIdx));
/* 156 */         project_holder.reset();
/* 157 */
/* 158 */         project_rowWriter.zeroOutNullBytes();
/* 159 */
/* 160 */         project_rowWriter.write(0, scan_value);
/* 161 */
/* 162 */         if (scan_isNull1) {
/* 163 */           project_rowWriter.setNullAt(1);
/* 164 */         } else {
/* 165 */           project_rowWriter.write(1, scan_value1);
/* 166 */         }
/* 167 */
/* 168 */         if (scan_isNull2) {
/* 169 */           project_rowWriter.setNullAt(2);
/* 170 */         } else {
/* 171 */           project_rowWriter.write(2, scan_value2);
/* 172 */         }
/* 173 */
/* 174 */         if (scan_isNull3) {
/* 175 */           project_rowWriter.setNullAt(3);
/* 176 */         } else {
/* 177 */           project_rowWriter.write(3, scan_value3);
/* 178 */         }
/* 179 */
/* 180 */         if (scan_isNull4) {
/* 181 */           project_rowWriter.setNullAt(4);
/* 182 */         } else {
/* 183 */           project_rowWriter.write(4, scan_value4);
/* 184 */         }
/* 185 */
/* 186 */         if (scan_isNull5) {
/* 187 */           project_rowWriter.setNullAt(5);
/* 188 */         } else {
/* 189 */           project_rowWriter.write(5, scan_value5);
/* 190 */         }
/* 191 */
/* 192 */         if (scan_isNull6) {
/* 193 */           project_rowWriter.setNullAt(6);
/* 194 */         } else {
/* 195 */           project_rowWriter.write(6, scan_value6);
/* 196 */         }
/* 197 */
/* 198 */         project_rowWriter.write(7, scan_value7);
/* 199 */
/* 200 */         if (scan_isNull8) {
/* 201 */           project_rowWriter.setNullAt(8);
/* 202 */         } else {
/* 203 */           project_rowWriter.write(8, scan_value8);
/* 204 */         }
/* 205 */
/* 206 */         if (scan_isNull9) {
/* 207 */           project_rowWriter.setNullAt(9);
/* 208 */         } else {
/* 209 */           project_rowWriter.write(9, scan_value9);
/* 210 */         }
/* 211 */
/* 212 */         if (scan_isNull10) {
/* 213 */           project_rowWriter.setNullAt(10);
/* 214 */         } else {
/* 215 */           project_rowWriter.write(10, scan_value10);
/* 216 */         }
/* 217 */
/* 218 */         if (scan_isNull11) {
/* 219 */           project_rowWriter.setNullAt(11);
/* 220 */         } else {
/* 221 */           project_rowWriter.write(11, scan_value11);
/* 222 */         }
/* 223 */         project_result.setTotalSize(project_holder.totalSize());
/* 224 */         append(project_result);
/* 225 */         if (shouldStop()) return;
/* 226 */       }
/* 227 */       scan_batch = null;
/* 228 */       scan_nextBatch();
/* 229 */     }
/* 230 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 231 */     scan_scanTime1 = 0;
/* 232 */   }
/* 233 */ }
