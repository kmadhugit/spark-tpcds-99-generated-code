/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private double agg_bufValue;
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private double agg_bufValue1;
/* 013 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 014 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 015 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 016 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 017 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 018 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 019 */   private scala.collection.Iterator inputadapter_input;
/* 020 */   private UnsafeRow agg_result;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 023 */   private int agg_value8;
/* 024 */   private UnsafeRow agg_result1;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 028 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 029 */
/* 030 */   public GeneratedIterator(Object[] references) {
/* 031 */     this.references = references;
/* 032 */   }
/* 033 */
/* 034 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 035 */     partitionIndex = index;
/* 036 */     this.inputs = inputs;
/* 037 */     agg_initAgg = false;
/* 038 */
/* 039 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 040 */
/* 041 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 042 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 043 */     inputadapter_input = inputs[0];
/* 044 */     agg_result = new UnsafeRow(2);
/* 045 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 046 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 047 */
/* 048 */     agg_result1 = new UnsafeRow(3);
/* 049 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 050 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 3);
/* 051 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 052 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 053 */
/* 054 */   }
/* 055 */
/* 056 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 057 */     agg_hashMap = agg_plan.createHashMap();
/* 058 */
/* 059 */     while (inputadapter_input.hasNext()) {
/* 060 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 061 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 062 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 063 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 064 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 065 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 066 */       double inputadapter_value2 = inputadapter_isNull2 ? -1.0 : (inputadapter_row.getDouble(2));
/* 067 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 068 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 069 */
/* 070 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 071 */
/* 072 */       UnsafeRow agg_fastAggBuffer = null;
/* 073 */
/* 074 */       if (agg_fastAggBuffer == null) {
/* 075 */         // generate grouping key
/* 076 */         agg_rowWriter.zeroOutNullBytes();
/* 077 */
/* 078 */         if (inputadapter_isNull) {
/* 079 */           agg_rowWriter.setNullAt(0);
/* 080 */         } else {
/* 081 */           agg_rowWriter.write(0, inputadapter_value);
/* 082 */         }
/* 083 */
/* 084 */         if (inputadapter_isNull1) {
/* 085 */           agg_rowWriter.setNullAt(1);
/* 086 */         } else {
/* 087 */           agg_rowWriter.write(1, inputadapter_value1);
/* 088 */         }
/* 089 */         agg_value8 = 42;
/* 090 */
/* 091 */         if (!inputadapter_isNull) {
/* 092 */           agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value8);
/* 093 */         }
/* 094 */
/* 095 */         if (!inputadapter_isNull1) {
/* 096 */           agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value8);
/* 097 */         }
/* 098 */         if (true) {
/* 099 */           // try to get the buffer from hash map
/* 100 */           agg_unsafeRowAggBuffer =
/* 101 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value8);
/* 102 */         }
/* 103 */         if (agg_unsafeRowAggBuffer == null) {
/* 104 */           if (agg_sorter == null) {
/* 105 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 106 */           } else {
/* 107 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 108 */           }
/* 109 */
/* 110 */           // the hash map had be spilled, it should have enough memory now,
/* 111 */           // try  to allocate buffer again.
/* 112 */           agg_unsafeRowAggBuffer =
/* 113 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value8);
/* 114 */           if (agg_unsafeRowAggBuffer == null) {
/* 115 */             // failed to allocate the first page
/* 116 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 117 */           }
/* 118 */         }
/* 119 */       }
/* 120 */
/* 121 */       if (agg_fastAggBuffer != null) {
/* 122 */         // update fast row
/* 123 */
/* 124 */       } else {
/* 125 */         // update unsafe row
/* 126 */
/* 127 */         // common sub-expressions
/* 128 */         boolean agg_isNull9 = false;
/* 129 */         double agg_value11 = -1.0;
/* 130 */         if (!false) {
/* 131 */           agg_value11 = (double) 0;
/* 132 */         }
/* 133 */         // evaluate aggregate function
/* 134 */         boolean agg_isNull12 = true;
/* 135 */         double agg_value14 = -1.0;
/* 136 */
/* 137 */         boolean agg_isNull14 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 138 */         double agg_value16 = agg_isNull14 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 139 */         boolean agg_isNull13 = agg_isNull14;
/* 140 */         double agg_value15 = agg_value16;
/* 141 */         if (agg_isNull13) {
/* 142 */           if (!agg_isNull9) {
/* 143 */             agg_isNull13 = false;
/* 144 */             agg_value15 = agg_value11;
/* 145 */           }
/* 146 */         }
/* 147 */
/* 148 */         if (!inputadapter_isNull2) {
/* 149 */           agg_isNull12 = false; // resultCode could change nullability.
/* 150 */           agg_value14 = agg_value15 + inputadapter_value2;
/* 151 */
/* 152 */         }
/* 153 */         boolean agg_isNull11 = agg_isNull12;
/* 154 */         double agg_value13 = agg_value14;
/* 155 */         if (agg_isNull11) {
/* 156 */           boolean agg_isNull16 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 157 */           double agg_value18 = agg_isNull16 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 158 */           if (!agg_isNull16) {
/* 159 */             agg_isNull11 = false;
/* 160 */             agg_value13 = agg_value18;
/* 161 */           }
/* 162 */         }
/* 163 */         boolean agg_isNull18 = true;
/* 164 */         double agg_value20 = -1.0;
/* 165 */
/* 166 */         boolean agg_isNull20 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 167 */         double agg_value22 = agg_isNull20 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 168 */         boolean agg_isNull19 = agg_isNull20;
/* 169 */         double agg_value21 = agg_value22;
/* 170 */         if (agg_isNull19) {
/* 171 */           if (!agg_isNull9) {
/* 172 */             agg_isNull19 = false;
/* 173 */             agg_value21 = agg_value11;
/* 174 */           }
/* 175 */         }
/* 176 */
/* 177 */         if (!inputadapter_isNull3) {
/* 178 */           agg_isNull18 = false; // resultCode could change nullability.
/* 179 */           agg_value20 = agg_value21 + inputadapter_value3;
/* 180 */
/* 181 */         }
/* 182 */         boolean agg_isNull17 = agg_isNull18;
/* 183 */         double agg_value19 = agg_value20;
/* 184 */         if (agg_isNull17) {
/* 185 */           boolean agg_isNull22 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 186 */           double agg_value24 = agg_isNull22 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 187 */           if (!agg_isNull22) {
/* 188 */             agg_isNull17 = false;
/* 189 */             agg_value19 = agg_value24;
/* 190 */           }
/* 191 */         }
/* 192 */         // update unsafe row buffer
/* 193 */         if (!agg_isNull11) {
/* 194 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value13);
/* 195 */         } else {
/* 196 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 197 */         }
/* 198 */
/* 199 */         if (!agg_isNull17) {
/* 200 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value19);
/* 201 */         } else {
/* 202 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 203 */         }
/* 204 */
/* 205 */       }
/* 206 */       if (shouldStop()) return;
/* 207 */     }
/* 208 */
/* 209 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 210 */   }
/* 211 */
/* 212 */   protected void processNext() throws java.io.IOException {
/* 213 */     if (!agg_initAgg) {
/* 214 */       agg_initAgg = true;
/* 215 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 216 */       agg_doAggregateWithKeys();
/* 217 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 218 */     }
/* 219 */
/* 220 */     // output the result
/* 221 */
/* 222 */     while (agg_mapIter.next()) {
/* 223 */       wholestagecodegen_numOutputRows.add(1);
/* 224 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 225 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 226 */
/* 227 */       boolean agg_isNull23 = agg_aggKey.isNullAt(0);
/* 228 */       int agg_value25 = agg_isNull23 ? -1 : (agg_aggKey.getInt(0));
/* 229 */       boolean agg_isNull24 = agg_aggKey.isNullAt(1);
/* 230 */       int agg_value26 = agg_isNull24 ? -1 : (agg_aggKey.getInt(1));
/* 231 */       boolean agg_isNull25 = agg_aggBuffer.isNullAt(0);
/* 232 */       double agg_value27 = agg_isNull25 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 233 */       boolean agg_isNull26 = agg_aggBuffer.isNullAt(1);
/* 234 */       double agg_value28 = agg_isNull26 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 235 */
/* 236 */       agg_rowWriter1.zeroOutNullBytes();
/* 237 */
/* 238 */       if (agg_isNull23) {
/* 239 */         agg_rowWriter1.setNullAt(0);
/* 240 */       } else {
/* 241 */         agg_rowWriter1.write(0, agg_value25);
/* 242 */       }
/* 243 */
/* 244 */       if (agg_isNull25) {
/* 245 */         agg_rowWriter1.setNullAt(1);
/* 246 */       } else {
/* 247 */         agg_rowWriter1.write(1, agg_value27);
/* 248 */       }
/* 249 */
/* 250 */       if (agg_isNull26) {
/* 251 */         agg_rowWriter1.setNullAt(2);
/* 252 */       } else {
/* 253 */         agg_rowWriter1.write(2, agg_value28);
/* 254 */       }
/* 255 */       append(agg_result1);
/* 256 */
/* 257 */       if (shouldStop()) return;
/* 258 */     }
/* 259 */
/* 260 */     agg_mapIter.close();
/* 261 */     if (agg_sorter == null) {
/* 262 */       agg_hashMap.free();
/* 263 */     }
/* 264 */   }
/* 265 */ }
