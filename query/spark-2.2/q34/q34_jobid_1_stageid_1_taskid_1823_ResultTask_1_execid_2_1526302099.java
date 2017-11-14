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
/* 017 */   private UnsafeRow scan_result;
/* 018 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 021 */   private UnsafeRow filter_result;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 024 */   private UnsafeRow project_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 027 */
/* 028 */   public GeneratedIterator(Object[] references) {
/* 029 */     this.references = references;
/* 030 */   }
/* 031 */
/* 032 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 033 */     partitionIndex = index;
/* 034 */     this.inputs = inputs;
/* 035 */     wholestagecodegen_init_0();
/* 036 */     wholestagecodegen_init_1();
/* 037 */
/* 038 */   }
/* 039 */
/* 040 */   private void wholestagecodegen_init_0() {
/* 041 */     scan_input = inputs[0];
/* 042 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 043 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 044 */     scan_scanTime1 = 0;
/* 045 */     scan_batch = null;
/* 046 */     scan_batchIdx = 0;
/* 047 */     scan_colInstance0 = null;
/* 048 */     scan_colInstance1 = null;
/* 049 */     scan_colInstance2 = null;
/* 050 */     scan_result = new UnsafeRow(3);
/* 051 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 052 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 053 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 054 */     filter_result = new UnsafeRow(3);
/* 055 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 056 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 057 */     project_result = new UnsafeRow(1);
/* 058 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 059 */
/* 060 */   }
/* 061 */
/* 062 */   private void scan_nextBatch() throws java.io.IOException {
/* 063 */     long getBatchStart = System.nanoTime();
/* 064 */     if (scan_input.hasNext()) {
/* 065 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 066 */       scan_numOutputRows.add(scan_batch.numRows());
/* 067 */       scan_batchIdx = 0;
/* 068 */       scan_colInstance0 = scan_batch.column(0);
/* 069 */       scan_colInstance1 = scan_batch.column(1);
/* 070 */       scan_colInstance2 = scan_batch.column(2);
/* 071 */
/* 072 */     }
/* 073 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 074 */   }
/* 075 */
/* 076 */   private void wholestagecodegen_init_1() {
/* 077 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 1);
/* 078 */
/* 079 */   }
/* 080 */
/* 081 */   protected void processNext() throws java.io.IOException {
/* 082 */     if (scan_batch == null) {
/* 083 */       scan_nextBatch();
/* 084 */     }
/* 085 */     while (scan_batch != null) {
/* 086 */       int scan_numRows = scan_batch.numRows();
/* 087 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 088 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 089 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 090 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 091 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 092 */
/* 093 */         boolean filter_isNull2 = true;
/* 094 */         boolean filter_value2 = false;
/* 095 */
/* 096 */         if (!scan_isNull2) {
/* 097 */           filter_isNull2 = false; // resultCode could change nullability.
/* 098 */           filter_value2 = scan_value2 >= 1;
/* 099 */
/* 100 */         }
/* 101 */         boolean filter_isNull1 = false;
/* 102 */         boolean filter_value1 = false;
/* 103 */
/* 104 */         if (!filter_isNull2 && !filter_value2) {
/* 105 */         } else {
/* 106 */           boolean filter_isNull5 = true;
/* 107 */           boolean filter_value5 = false;
/* 108 */
/* 109 */           if (!scan_isNull2) {
/* 110 */             filter_isNull5 = false; // resultCode could change nullability.
/* 111 */             filter_value5 = scan_value2 <= 3;
/* 112 */
/* 113 */           }
/* 114 */           if (!filter_isNull5 && !filter_value5) {
/* 115 */           } else if (!filter_isNull2 && !filter_isNull5) {
/* 116 */             filter_value1 = true;
/* 117 */           } else {
/* 118 */             filter_isNull1 = true;
/* 119 */           }
/* 120 */         }
/* 121 */         boolean filter_isNull = false;
/* 122 */         boolean filter_value = true;
/* 123 */
/* 124 */         if (!filter_isNull1 && filter_value1) {
/* 125 */         } else {
/* 126 */           boolean filter_isNull9 = true;
/* 127 */           boolean filter_value9 = false;
/* 128 */
/* 129 */           if (!scan_isNull2) {
/* 130 */             filter_isNull9 = false; // resultCode could change nullability.
/* 131 */             filter_value9 = scan_value2 >= 25;
/* 132 */
/* 133 */           }
/* 134 */           boolean filter_isNull8 = false;
/* 135 */           boolean filter_value8 = false;
/* 136 */
/* 137 */           if (!filter_isNull9 && !filter_value9) {
/* 138 */           } else {
/* 139 */             boolean filter_isNull12 = true;
/* 140 */             boolean filter_value12 = false;
/* 141 */
/* 142 */             if (!scan_isNull2) {
/* 143 */               filter_isNull12 = false; // resultCode could change nullability.
/* 144 */               filter_value12 = scan_value2 <= 28;
/* 145 */
/* 146 */             }
/* 147 */             if (!filter_isNull12 && !filter_value12) {
/* 148 */             } else if (!filter_isNull9 && !filter_isNull12) {
/* 149 */               filter_value8 = true;
/* 150 */             } else {
/* 151 */               filter_isNull8 = true;
/* 152 */             }
/* 153 */           }
/* 154 */           if (!filter_isNull8 && filter_value8) {
/* 155 */           } else if (!filter_isNull1 && !filter_isNull8) {
/* 156 */             filter_value = false;
/* 157 */           } else {
/* 158 */             filter_isNull = true;
/* 159 */           }
/* 160 */         }
/* 161 */         if (filter_isNull || !filter_value) continue;
/* 162 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 163 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 164 */
/* 165 */         boolean filter_value15 = false;
/* 166 */         boolean filter_isNull15 = scan_isNull1;
/* 167 */         if (!filter_isNull15) {
/* 168 */           if (!filter_value15) {
/* 169 */             if (false) {
/* 170 */               filter_isNull15 = true;
/* 171 */             } else if (scan_value1 == 1999) {
/* 172 */               filter_isNull15 = false;
/* 173 */               filter_value15 = true;
/* 174 */             }
/* 175 */           }
/* 176 */
/* 177 */           if (!filter_value15) {
/* 178 */             if (false) {
/* 179 */               filter_isNull15 = true;
/* 180 */             } else if (scan_value1 == 2000) {
/* 181 */               filter_isNull15 = false;
/* 182 */               filter_value15 = true;
/* 183 */             }
/* 184 */           }
/* 185 */
/* 186 */           if (!filter_value15) {
/* 187 */             if (false) {
/* 188 */               filter_isNull15 = true;
/* 189 */             } else if (scan_value1 == 2001) {
/* 190 */               filter_isNull15 = false;
/* 191 */               filter_value15 = true;
/* 192 */             }
/* 193 */           }
/* 194 */
/* 195 */         }
/* 196 */         if (filter_isNull15 || !filter_value15) continue;
/* 197 */
/* 198 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 199 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 200 */
/* 201 */         if (!(!(scan_isNull))) continue;
/* 202 */
/* 203 */         filter_numOutputRows.add(1);
/* 204 */
/* 205 */         project_rowWriter.write(0, scan_value);
/* 206 */         append(project_result);
/* 207 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 208 */       }
/* 209 */       scan_batchIdx = scan_numRows;
/* 210 */       scan_batch = null;
/* 211 */       scan_nextBatch();
/* 212 */     }
/* 213 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 214 */     scan_scanTime1 = 0;
/* 215 */   }
/* 216 */ }
