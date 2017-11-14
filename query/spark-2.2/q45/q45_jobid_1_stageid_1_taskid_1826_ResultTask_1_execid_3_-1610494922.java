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
/* 016 */   private UnsafeRow scan_result;
/* 017 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 018 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 019 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 020 */   private UnsafeRow filter_result;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 023 */   private UnsafeRow project_result;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 026 */
/* 027 */   public GeneratedIterator(Object[] references) {
/* 028 */     this.references = references;
/* 029 */   }
/* 030 */
/* 031 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 032 */     partitionIndex = index;
/* 033 */     this.inputs = inputs;
/* 034 */     wholestagecodegen_init_0();
/* 035 */     wholestagecodegen_init_1();
/* 036 */
/* 037 */   }
/* 038 */
/* 039 */   private void wholestagecodegen_init_0() {
/* 040 */     scan_input = inputs[0];
/* 041 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 042 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 043 */     scan_scanTime1 = 0;
/* 044 */     scan_batch = null;
/* 045 */     scan_batchIdx = 0;
/* 046 */     scan_colInstance0 = null;
/* 047 */     scan_colInstance1 = null;
/* 048 */     scan_result = new UnsafeRow(2);
/* 049 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 32);
/* 050 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 2);
/* 051 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 052 */     filter_result = new UnsafeRow(2);
/* 053 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 32);
/* 054 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 2);
/* 055 */     project_result = new UnsafeRow(1);
/* 056 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 057 */
/* 058 */   }
/* 059 */
/* 060 */   private void scan_nextBatch() throws java.io.IOException {
/* 061 */     long getBatchStart = System.nanoTime();
/* 062 */     if (scan_input.hasNext()) {
/* 063 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 064 */       scan_numOutputRows.add(scan_batch.numRows());
/* 065 */       scan_batchIdx = 0;
/* 066 */       scan_colInstance0 = scan_batch.column(0);
/* 067 */       scan_colInstance1 = scan_batch.column(1);
/* 068 */
/* 069 */     }
/* 070 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 071 */   }
/* 072 */
/* 073 */   private void wholestagecodegen_init_1() {
/* 074 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 1);
/* 075 */
/* 076 */   }
/* 077 */
/* 078 */   protected void processNext() throws java.io.IOException {
/* 079 */     if (scan_batch == null) {
/* 080 */       scan_nextBatch();
/* 081 */     }
/* 082 */     while (scan_batch != null) {
/* 083 */       int scan_numRows = scan_batch.numRows();
/* 084 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 085 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 086 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 087 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 088 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 089 */
/* 090 */         boolean filter_value = false;
/* 091 */         boolean filter_isNull = scan_isNull;
/* 092 */         if (!filter_isNull) {
/* 093 */           if (!filter_value) {
/* 094 */             if (false) {
/* 095 */               filter_isNull = true;
/* 096 */             } else if (scan_value == 2) {
/* 097 */               filter_isNull = false;
/* 098 */               filter_value = true;
/* 099 */             }
/* 100 */           }
/* 101 */
/* 102 */           if (!filter_value) {
/* 103 */             if (false) {
/* 104 */               filter_isNull = true;
/* 105 */             } else if (scan_value == 3) {
/* 106 */               filter_isNull = false;
/* 107 */               filter_value = true;
/* 108 */             }
/* 109 */           }
/* 110 */
/* 111 */           if (!filter_value) {
/* 112 */             if (false) {
/* 113 */               filter_isNull = true;
/* 114 */             } else if (scan_value == 5) {
/* 115 */               filter_isNull = false;
/* 116 */               filter_value = true;
/* 117 */             }
/* 118 */           }
/* 119 */
/* 120 */           if (!filter_value) {
/* 121 */             if (false) {
/* 122 */               filter_isNull = true;
/* 123 */             } else if (scan_value == 7) {
/* 124 */               filter_isNull = false;
/* 125 */               filter_value = true;
/* 126 */             }
/* 127 */           }
/* 128 */
/* 129 */           if (!filter_value) {
/* 130 */             if (false) {
/* 131 */               filter_isNull = true;
/* 132 */             } else if (scan_value == 11) {
/* 133 */               filter_isNull = false;
/* 134 */               filter_value = true;
/* 135 */             }
/* 136 */           }
/* 137 */
/* 138 */           if (!filter_value) {
/* 139 */             if (false) {
/* 140 */               filter_isNull = true;
/* 141 */             } else if (scan_value == 13) {
/* 142 */               filter_isNull = false;
/* 143 */               filter_value = true;
/* 144 */             }
/* 145 */           }
/* 146 */
/* 147 */           if (!filter_value) {
/* 148 */             if (false) {
/* 149 */               filter_isNull = true;
/* 150 */             } else if (scan_value == 17) {
/* 151 */               filter_isNull = false;
/* 152 */               filter_value = true;
/* 153 */             }
/* 154 */           }
/* 155 */
/* 156 */           if (!filter_value) {
/* 157 */             if (false) {
/* 158 */               filter_isNull = true;
/* 159 */             } else if (scan_value == 19) {
/* 160 */               filter_isNull = false;
/* 161 */               filter_value = true;
/* 162 */             }
/* 163 */           }
/* 164 */
/* 165 */           if (!filter_value) {
/* 166 */             if (false) {
/* 167 */               filter_isNull = true;
/* 168 */             } else if (scan_value == 23) {
/* 169 */               filter_isNull = false;
/* 170 */               filter_value = true;
/* 171 */             }
/* 172 */           }
/* 173 */
/* 174 */           if (!filter_value) {
/* 175 */             if (false) {
/* 176 */               filter_isNull = true;
/* 177 */             } else if (scan_value == 29) {
/* 178 */               filter_isNull = false;
/* 179 */               filter_value = true;
/* 180 */             }
/* 181 */           }
/* 182 */
/* 183 */         }
/* 184 */         if (filter_isNull || !filter_value) continue;
/* 185 */
/* 186 */         filter_numOutputRows.add(1);
/* 187 */
/* 188 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 189 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 190 */         project_holder.reset();
/* 191 */
/* 192 */         project_rowWriter.zeroOutNullBytes();
/* 193 */
/* 194 */         if (scan_isNull1) {
/* 195 */           project_rowWriter.setNullAt(0);
/* 196 */         } else {
/* 197 */           project_rowWriter.write(0, scan_value1);
/* 198 */         }
/* 199 */         project_result.setTotalSize(project_holder.totalSize());
/* 200 */         append(project_result);
/* 201 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 202 */       }
/* 203 */       scan_batchIdx = scan_numRows;
/* 204 */       scan_batch = null;
/* 205 */       scan_nextBatch();
/* 206 */     }
/* 207 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 208 */     scan_scanTime1 = 0;
/* 209 */   }
/* 210 */ }
