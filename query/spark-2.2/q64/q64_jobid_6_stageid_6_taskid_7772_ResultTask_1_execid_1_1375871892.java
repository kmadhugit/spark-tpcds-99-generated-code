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
/* 018 */   private UnsafeRow scan_result;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 021 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 022 */   private UnsafeRow filter_result;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 025 */   private UnsafeRow project_result;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 028 */
/* 029 */   public GeneratedIterator(Object[] references) {
/* 030 */     this.references = references;
/* 031 */   }
/* 032 */
/* 033 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 034 */     partitionIndex = index;
/* 035 */     this.inputs = inputs;
/* 036 */     wholestagecodegen_init_0();
/* 037 */     wholestagecodegen_init_1();
/* 038 */
/* 039 */   }
/* 040 */
/* 041 */   private void wholestagecodegen_init_0() {
/* 042 */     scan_input = inputs[0];
/* 043 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 044 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 045 */     scan_scanTime1 = 0;
/* 046 */     scan_batch = null;
/* 047 */     scan_batchIdx = 0;
/* 048 */     scan_colInstance0 = null;
/* 049 */     scan_colInstance1 = null;
/* 050 */     scan_colInstance2 = null;
/* 051 */     scan_colInstance3 = null;
/* 052 */     scan_result = new UnsafeRow(4);
/* 053 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 64);
/* 054 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 4);
/* 055 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 056 */     filter_result = new UnsafeRow(4);
/* 057 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 64);
/* 058 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 059 */     project_result = new UnsafeRow(2);
/* 060 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 061 */
/* 062 */   }
/* 063 */
/* 064 */   private void scan_nextBatch() throws java.io.IOException {
/* 065 */     long getBatchStart = System.nanoTime();
/* 066 */     if (scan_input.hasNext()) {
/* 067 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 068 */       scan_numOutputRows.add(scan_batch.numRows());
/* 069 */       scan_batchIdx = 0;
/* 070 */       scan_colInstance0 = scan_batch.column(0);
/* 071 */       scan_colInstance1 = scan_batch.column(1);
/* 072 */       scan_colInstance2 = scan_batch.column(2);
/* 073 */       scan_colInstance3 = scan_batch.column(3);
/* 074 */
/* 075 */     }
/* 076 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 077 */   }
/* 078 */
/* 079 */   private void wholestagecodegen_init_1() {
/* 080 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 081 */
/* 082 */   }
/* 083 */
/* 084 */   protected void processNext() throws java.io.IOException {
/* 085 */     if (scan_batch == null) {
/* 086 */       scan_nextBatch();
/* 087 */     }
/* 088 */     while (scan_batch != null) {
/* 089 */       int scan_numRows = scan_batch.numRows();
/* 090 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 091 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 092 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 093 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 094 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 095 */
/* 096 */         boolean filter_value = false;
/* 097 */         boolean filter_isNull = scan_isNull2;
/* 098 */         if (!filter_isNull) {
/* 099 */           if (!filter_value) {
/* 100 */             if (false) {
/* 101 */               filter_isNull = true;
/* 102 */             } else if (scan_value2.equals(((UTF8String) references[3]))) {
/* 103 */               filter_isNull = false;
/* 104 */               filter_value = true;
/* 105 */             }
/* 106 */           }
/* 107 */
/* 108 */           if (!filter_value) {
/* 109 */             if (false) {
/* 110 */               filter_isNull = true;
/* 111 */             } else if (scan_value2.equals(((UTF8String) references[4]))) {
/* 112 */               filter_isNull = false;
/* 113 */               filter_value = true;
/* 114 */             }
/* 115 */           }
/* 116 */
/* 117 */           if (!filter_value) {
/* 118 */             if (false) {
/* 119 */               filter_isNull = true;
/* 120 */             } else if (scan_value2.equals(((UTF8String) references[5]))) {
/* 121 */               filter_isNull = false;
/* 122 */               filter_value = true;
/* 123 */             }
/* 124 */           }
/* 125 */
/* 126 */           if (!filter_value) {
/* 127 */             if (false) {
/* 128 */               filter_isNull = true;
/* 129 */             } else if (scan_value2.equals(((UTF8String) references[6]))) {
/* 130 */               filter_isNull = false;
/* 131 */               filter_value = true;
/* 132 */             }
/* 133 */           }
/* 134 */
/* 135 */           if (!filter_value) {
/* 136 */             if (false) {
/* 137 */               filter_isNull = true;
/* 138 */             } else if (scan_value2.equals(((UTF8String) references[7]))) {
/* 139 */               filter_isNull = false;
/* 140 */               filter_value = true;
/* 141 */             }
/* 142 */           }
/* 143 */
/* 144 */           if (!filter_value) {
/* 145 */             if (false) {
/* 146 */               filter_isNull = true;
/* 147 */             } else if (scan_value2.equals(((UTF8String) references[8]))) {
/* 148 */               filter_isNull = false;
/* 149 */               filter_value = true;
/* 150 */             }
/* 151 */           }
/* 152 */
/* 153 */         }
/* 154 */         if (filter_isNull || !filter_value) continue;
/* 155 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 156 */         double scan_value1 = scan_isNull1 ? -1.0 : (scan_colInstance1.getDouble(scan_rowIdx));
/* 157 */
/* 158 */         if (!(!(scan_isNull1))) continue;
/* 159 */
/* 160 */         boolean filter_isNull10 = false;
/* 161 */
/* 162 */         boolean filter_value10 = false;
/* 163 */         filter_value10 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value1, 64.0D) >= 0;
/* 164 */         if (!filter_value10) continue;
/* 165 */         boolean filter_isNull13 = false;
/* 166 */
/* 167 */         boolean filter_value13 = false;
/* 168 */         filter_value13 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value1, 74.0D) <= 0;
/* 169 */         if (!filter_value13) continue;
/* 170 */         boolean filter_isNull16 = false;
/* 171 */
/* 172 */         boolean filter_value16 = false;
/* 173 */         filter_value16 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value1, 65.0D) >= 0;
/* 174 */         if (!filter_value16) continue;
/* 175 */         boolean filter_isNull19 = false;
/* 176 */
/* 177 */         boolean filter_value19 = false;
/* 178 */         filter_value19 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value1, 79.0D) <= 0;
/* 179 */         if (!filter_value19) continue;
/* 180 */
/* 181 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 182 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 183 */
/* 184 */         if (!(!(scan_isNull))) continue;
/* 185 */
/* 186 */         filter_numOutputRows.add(1);
/* 187 */
/* 188 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 189 */         UTF8String scan_value3 = scan_isNull3 ? null : (scan_colInstance3.getUTF8String(scan_rowIdx));
/* 190 */         project_holder.reset();
/* 191 */
/* 192 */         project_rowWriter.zeroOutNullBytes();
/* 193 */
/* 194 */         project_rowWriter.write(0, scan_value);
/* 195 */
/* 196 */         if (scan_isNull3) {
/* 197 */           project_rowWriter.setNullAt(1);
/* 198 */         } else {
/* 199 */           project_rowWriter.write(1, scan_value3);
/* 200 */         }
/* 201 */         project_result.setTotalSize(project_holder.totalSize());
/* 202 */         append(project_result);
/* 203 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 204 */       }
/* 205 */       scan_batchIdx = scan_numRows;
/* 206 */       scan_batch = null;
/* 207 */       scan_nextBatch();
/* 208 */     }
/* 209 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 210 */     scan_scanTime1 = 0;
/* 211 */   }
/* 212 */ }
