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
/* 110 */       int numRows = scan_batch.numRows();
/* 111 */       while (scan_batchIdx < numRows) {
/* 112 */         int scan_rowIdx = scan_batchIdx++;
/* 113 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 114 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 115 */
/* 116 */         if (!(!(scan_isNull))) continue;
/* 117 */
/* 118 */         filter_numOutputRows.add(1);
/* 119 */
/* 120 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 121 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 122 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 123 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 124 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 125 */         UTF8String scan_value3 = scan_isNull3 ? null : (scan_colInstance3.getUTF8String(scan_rowIdx));
/* 126 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 127 */         UTF8String scan_value4 = scan_isNull4 ? null : (scan_colInstance4.getUTF8String(scan_rowIdx));
/* 128 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 129 */         UTF8String scan_value5 = scan_isNull5 ? null : (scan_colInstance5.getUTF8String(scan_rowIdx));
/* 130 */         boolean scan_isNull6 = scan_colInstance6.isNullAt(scan_rowIdx);
/* 131 */         UTF8String scan_value6 = scan_isNull6 ? null : (scan_colInstance6.getUTF8String(scan_rowIdx));
/* 132 */         boolean scan_isNull7 = scan_colInstance7.isNullAt(scan_rowIdx);
/* 133 */         UTF8String scan_value7 = scan_isNull7 ? null : (scan_colInstance7.getUTF8String(scan_rowIdx));
/* 134 */         boolean scan_isNull8 = scan_colInstance8.isNullAt(scan_rowIdx);
/* 135 */         UTF8String scan_value8 = scan_isNull8 ? null : (scan_colInstance8.getUTF8String(scan_rowIdx));
/* 136 */         boolean scan_isNull9 = scan_colInstance9.isNullAt(scan_rowIdx);
/* 137 */         UTF8String scan_value9 = scan_isNull9 ? null : (scan_colInstance9.getUTF8String(scan_rowIdx));
/* 138 */         boolean scan_isNull10 = scan_colInstance10.isNullAt(scan_rowIdx);
/* 139 */         UTF8String scan_value10 = scan_isNull10 ? null : (scan_colInstance10.getUTF8String(scan_rowIdx));
/* 140 */         project_holder.reset();
/* 141 */
/* 142 */         project_rowWriter.zeroOutNullBytes();
/* 143 */
/* 144 */         project_rowWriter.write(0, scan_value);
/* 145 */
/* 146 */         if (scan_isNull1) {
/* 147 */           project_rowWriter.setNullAt(1);
/* 148 */         } else {
/* 149 */           project_rowWriter.write(1, scan_value1);
/* 150 */         }
/* 151 */
/* 152 */         if (scan_isNull2) {
/* 153 */           project_rowWriter.setNullAt(2);
/* 154 */         } else {
/* 155 */           project_rowWriter.write(2, scan_value2);
/* 156 */         }
/* 157 */
/* 158 */         if (scan_isNull3) {
/* 159 */           project_rowWriter.setNullAt(3);
/* 160 */         } else {
/* 161 */           project_rowWriter.write(3, scan_value3);
/* 162 */         }
/* 163 */
/* 164 */         if (scan_isNull4) {
/* 165 */           project_rowWriter.setNullAt(4);
/* 166 */         } else {
/* 167 */           project_rowWriter.write(4, scan_value4);
/* 168 */         }
/* 169 */
/* 170 */         if (scan_isNull5) {
/* 171 */           project_rowWriter.setNullAt(5);
/* 172 */         } else {
/* 173 */           project_rowWriter.write(5, scan_value5);
/* 174 */         }
/* 175 */
/* 176 */         if (scan_isNull6) {
/* 177 */           project_rowWriter.setNullAt(6);
/* 178 */         } else {
/* 179 */           project_rowWriter.write(6, scan_value6);
/* 180 */         }
/* 181 */
/* 182 */         if (scan_isNull7) {
/* 183 */           project_rowWriter.setNullAt(7);
/* 184 */         } else {
/* 185 */           project_rowWriter.write(7, scan_value7);
/* 186 */         }
/* 187 */
/* 188 */         if (scan_isNull8) {
/* 189 */           project_rowWriter.setNullAt(8);
/* 190 */         } else {
/* 191 */           project_rowWriter.write(8, scan_value8);
/* 192 */         }
/* 193 */
/* 194 */         if (scan_isNull9) {
/* 195 */           project_rowWriter.setNullAt(9);
/* 196 */         } else {
/* 197 */           project_rowWriter.write(9, scan_value9);
/* 198 */         }
/* 199 */
/* 200 */         if (scan_isNull10) {
/* 201 */           project_rowWriter.setNullAt(10);
/* 202 */         } else {
/* 203 */           project_rowWriter.write(10, scan_value10);
/* 204 */         }
/* 205 */         project_result.setTotalSize(project_holder.totalSize());
/* 206 */         append(project_result);
/* 207 */         if (shouldStop()) return;
/* 208 */       }
/* 209 */       scan_batch = null;
/* 210 */       scan_nextBatch();
/* 211 */     }
/* 212 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 213 */     scan_scanTime1 = 0;
/* 214 */   }
/* 215 */ }
