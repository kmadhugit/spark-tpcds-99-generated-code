/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 010 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 011 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 012 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 013 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 014 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 015 */   private scala.collection.Iterator inputadapter_input;
/* 016 */   private UnsafeRow agg_result;
/* 017 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 018 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 019 */   private int agg_value14;
/* 020 */   private UnsafeRow agg_result1;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 023 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 024 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 025 */
/* 026 */   public GeneratedIterator(Object[] references) {
/* 027 */     this.references = references;
/* 028 */   }
/* 029 */
/* 030 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 031 */     partitionIndex = index;
/* 032 */     this.inputs = inputs;
/* 033 */     agg_initAgg = false;
/* 034 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 035 */
/* 036 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 037 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 038 */     inputadapter_input = inputs[0];
/* 039 */     agg_result = new UnsafeRow(7);
/* 040 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 041 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 7);
/* 042 */
/* 043 */     agg_result1 = new UnsafeRow(7);
/* 044 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 045 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 7);
/* 046 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 047 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 048 */
/* 049 */   }
/* 050 */
/* 051 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 052 */     agg_hashMap = agg_plan.createHashMap();
/* 053 */
/* 054 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 055 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 056 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 057 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 058 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 059 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 060 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 061 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 062 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 063 */       int inputadapter_value3 = inputadapter_isNull3 ? -1 : (inputadapter_row.getInt(3));
/* 064 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 065 */       int inputadapter_value4 = inputadapter_isNull4 ? -1 : (inputadapter_row.getInt(4));
/* 066 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 067 */       long inputadapter_value5 = inputadapter_isNull5 ? -1L : (inputadapter_row.getLong(5));
/* 068 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 069 */       double inputadapter_value6 = inputadapter_isNull6 ? -1.0 : (inputadapter_row.getDouble(6));
/* 070 */
/* 071 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 072 */
/* 073 */       UnsafeRow agg_fastAggBuffer = null;
/* 074 */
/* 075 */       if (agg_fastAggBuffer == null) {
/* 076 */         // generate grouping key
/* 077 */         agg_rowWriter.zeroOutNullBytes();
/* 078 */
/* 079 */         if (inputadapter_isNull) {
/* 080 */           agg_rowWriter.setNullAt(0);
/* 081 */         } else {
/* 082 */           agg_rowWriter.write(0, inputadapter_value);
/* 083 */         }
/* 084 */
/* 085 */         if (inputadapter_isNull1) {
/* 086 */           agg_rowWriter.setNullAt(1);
/* 087 */         } else {
/* 088 */           agg_rowWriter.write(1, inputadapter_value1);
/* 089 */         }
/* 090 */
/* 091 */         if (inputadapter_isNull2) {
/* 092 */           agg_rowWriter.setNullAt(2);
/* 093 */         } else {
/* 094 */           agg_rowWriter.write(2, inputadapter_value2);
/* 095 */         }
/* 096 */
/* 097 */         if (inputadapter_isNull3) {
/* 098 */           agg_rowWriter.setNullAt(3);
/* 099 */         } else {
/* 100 */           agg_rowWriter.write(3, inputadapter_value3);
/* 101 */         }
/* 102 */
/* 103 */         if (inputadapter_isNull4) {
/* 104 */           agg_rowWriter.setNullAt(4);
/* 105 */         } else {
/* 106 */           agg_rowWriter.write(4, inputadapter_value4);
/* 107 */         }
/* 108 */
/* 109 */         if (inputadapter_isNull5) {
/* 110 */           agg_rowWriter.setNullAt(5);
/* 111 */         } else {
/* 112 */           agg_rowWriter.write(5, inputadapter_value5);
/* 113 */         }
/* 114 */
/* 115 */         if (inputadapter_isNull6) {
/* 116 */           agg_rowWriter.setNullAt(6);
/* 117 */         } else {
/* 118 */           agg_rowWriter.write(6, inputadapter_value6);
/* 119 */         }
/* 120 */         agg_value14 = 42;
/* 121 */
/* 122 */         if (!inputadapter_isNull) {
/* 123 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value14);
/* 124 */         }
/* 125 */
/* 126 */         if (!inputadapter_isNull1) {
/* 127 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value14);
/* 128 */         }
/* 129 */
/* 130 */         if (!inputadapter_isNull2) {
/* 131 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value2, agg_value14);
/* 132 */         }
/* 133 */
/* 134 */         if (!inputadapter_isNull3) {
/* 135 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value3, agg_value14);
/* 136 */         }
/* 137 */
/* 138 */         if (!inputadapter_isNull4) {
/* 139 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value4, agg_value14);
/* 140 */         }
/* 141 */
/* 142 */         if (!inputadapter_isNull5) {
/* 143 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashLong(inputadapter_value5, agg_value14);
/* 144 */         }
/* 145 */
/* 146 */         if (!inputadapter_isNull6) {
/* 147 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashLong(Double.doubleToLongBits(inputadapter_value6), agg_value14);
/* 148 */         }
/* 149 */         if (true) {
/* 150 */           // try to get the buffer from hash map
/* 151 */           agg_unsafeRowAggBuffer =
/* 152 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value14);
/* 153 */         }
/* 154 */         if (agg_unsafeRowAggBuffer == null) {
/* 155 */           if (agg_sorter == null) {
/* 156 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 157 */           } else {
/* 158 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 159 */           }
/* 160 */
/* 161 */           // the hash map had be spilled, it should have enough memory now,
/* 162 */           // try  to allocate buffer again.
/* 163 */           agg_unsafeRowAggBuffer =
/* 164 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value14);
/* 165 */           if (agg_unsafeRowAggBuffer == null) {
/* 166 */             // failed to allocate the first page
/* 167 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 168 */           }
/* 169 */         }
/* 170 */       }
/* 171 */
/* 172 */       if (agg_fastAggBuffer != null) {
/* 173 */         // update fast row
/* 174 */
/* 175 */       } else {
/* 176 */         // update unsafe row
/* 177 */
/* 178 */         // common sub-expressions
/* 179 */
/* 180 */         // evaluate aggregate function
/* 181 */
/* 182 */         // update unsafe row buffer
/* 183 */
/* 184 */       }
/* 185 */       if (shouldStop()) return;
/* 186 */     }
/* 187 */
/* 188 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 189 */   }
/* 190 */
/* 191 */   protected void processNext() throws java.io.IOException {
/* 192 */     if (!agg_initAgg) {
/* 193 */       agg_initAgg = true;
/* 194 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 195 */       agg_doAggregateWithKeys();
/* 196 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 197 */     }
/* 198 */
/* 199 */     // output the result
/* 200 */
/* 201 */     while (agg_mapIter.next()) {
/* 202 */       wholestagecodegen_numOutputRows.add(1);
/* 203 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 204 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 205 */
/* 206 */       boolean agg_isNull22 = agg_aggKey.isNullAt(0);
/* 207 */       int agg_value22 = agg_isNull22 ? -1 : (agg_aggKey.getInt(0));
/* 208 */       boolean agg_isNull23 = agg_aggKey.isNullAt(1);
/* 209 */       int agg_value23 = agg_isNull23 ? -1 : (agg_aggKey.getInt(1));
/* 210 */       boolean agg_isNull24 = agg_aggKey.isNullAt(2);
/* 211 */       int agg_value24 = agg_isNull24 ? -1 : (agg_aggKey.getInt(2));
/* 212 */       boolean agg_isNull25 = agg_aggKey.isNullAt(3);
/* 213 */       int agg_value25 = agg_isNull25 ? -1 : (agg_aggKey.getInt(3));
/* 214 */       boolean agg_isNull26 = agg_aggKey.isNullAt(4);
/* 215 */       int agg_value26 = agg_isNull26 ? -1 : (agg_aggKey.getInt(4));
/* 216 */       boolean agg_isNull27 = agg_aggKey.isNullAt(5);
/* 217 */       long agg_value27 = agg_isNull27 ? -1L : (agg_aggKey.getLong(5));
/* 218 */       boolean agg_isNull28 = agg_aggKey.isNullAt(6);
/* 219 */       double agg_value28 = agg_isNull28 ? -1.0 : (agg_aggKey.getDouble(6));
/* 220 */       agg_rowWriter1.zeroOutNullBytes();
/* 221 */
/* 222 */       if (agg_isNull22) {
/* 223 */         agg_rowWriter1.setNullAt(0);
/* 224 */       } else {
/* 225 */         agg_rowWriter1.write(0, agg_value22);
/* 226 */       }
/* 227 */
/* 228 */       if (agg_isNull23) {
/* 229 */         agg_rowWriter1.setNullAt(1);
/* 230 */       } else {
/* 231 */         agg_rowWriter1.write(1, agg_value23);
/* 232 */       }
/* 233 */
/* 234 */       if (agg_isNull24) {
/* 235 */         agg_rowWriter1.setNullAt(2);
/* 236 */       } else {
/* 237 */         agg_rowWriter1.write(2, agg_value24);
/* 238 */       }
/* 239 */
/* 240 */       if (agg_isNull25) {
/* 241 */         agg_rowWriter1.setNullAt(3);
/* 242 */       } else {
/* 243 */         agg_rowWriter1.write(3, agg_value25);
/* 244 */       }
/* 245 */
/* 246 */       if (agg_isNull26) {
/* 247 */         agg_rowWriter1.setNullAt(4);
/* 248 */       } else {
/* 249 */         agg_rowWriter1.write(4, agg_value26);
/* 250 */       }
/* 251 */
/* 252 */       if (agg_isNull27) {
/* 253 */         agg_rowWriter1.setNullAt(5);
/* 254 */       } else {
/* 255 */         agg_rowWriter1.write(5, agg_value27);
/* 256 */       }
/* 257 */
/* 258 */       if (agg_isNull28) {
/* 259 */         agg_rowWriter1.setNullAt(6);
/* 260 */       } else {
/* 261 */         agg_rowWriter1.write(6, agg_value28);
/* 262 */       }
/* 263 */       append(agg_result1);
/* 264 */
/* 265 */       if (shouldStop()) return;
/* 266 */     }
/* 267 */
/* 268 */     agg_mapIter.close();
/* 269 */     if (agg_sorter == null) {
/* 270 */       agg_hashMap.free();
/* 271 */     }
/* 272 */   }
/* 273 */ }
